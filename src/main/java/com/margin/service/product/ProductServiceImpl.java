package com.margin.service.product;

import com.margin.repository.product.ProductRepository;
import com.margin.repository.product.entity.ProductEntity;
import com.margin.repository.shop.ShopRepository;
import com.margin.repository.shop.entity.ShopEntity;
import com.margin.service.product.converter.ProductEntityConverter;
import com.margin.service.product.converter.ProductModelConverter;
import com.margin.service.product.model.ProductCreationModel;
import com.margin.service.product.model.ProductModel;
import com.margin.service.product.model.ProductUpdateModel;
import com.margin.service.product.validator.ProductHasDescriptionValidator;
import com.margin.service.product.validator.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductEntityConverter productEntityConverter;

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ProductModelConverter productModelConverter;

    @Autowired
    private ProductValidator productValidator;

    @Autowired
    private ProductHasDescriptionValidator hasDescriptionValidator;

    public ProductModel get(Long id) {
        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product with " + id + " id does not exist."));
        return productEntityConverter.convert(productEntity);
    }

    @Transactional
    @Override
    public ProductModel create(ProductCreationModel productCreationModel) {
        productValidator.productIsValid(productCreationModel);
        ProductEntity productEntity = productModelConverter.convert(productCreationModel);
        ShopEntity shop = shopRepository.findById(productCreationModel.getShopId()).orElseThrow(()
                -> new EntityNotFoundException("Shop with id " + productCreationModel.getShopId() +
                " does not exist"));
        productEntity.setShopEntity(shop);
        productEntity = productRepository.save(productEntity);
        return productEntityConverter.convert(productEntity);
    }

    @Transactional
    @Override
    public ProductModel update(ProductUpdateModel productUpdateModel) {
        productValidator.productIsValid(productUpdateModel);
        ProductEntity productEntity = productRepository.findById(productUpdateModel.getId())
                .orElseThrow(() -> new EntityNotFoundException("Product with id" +
                        productUpdateModel.getId() + " does not exist"));
        if (nameIsChanged(productEntity.getName(), productUpdateModel.getName())) {
            productValidator.productIsValid(productUpdateModel);
        } else {
            hasDescriptionValidator.productHasDescription(productUpdateModel.getDescription());
        }
        productEntity = productModelConverter.convert(productUpdateModel, productEntity);
        productEntity = productRepository.save(productEntity);
        return productEntityConverter.convert(productEntity);
    }

    @Override
    public Boolean delete(Long id) {
        productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product with this id does not exist"));
        productRepository.updateDeleted(id);
        return true;
    }

    public Boolean nameIsChanged(String oldName, String newName) {
        return !oldName.equalsIgnoreCase(newName);
    }
}
