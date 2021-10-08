package com.margin.service.product;

import com.margin.entity.ProductEntity;
import com.margin.entity.ShopEntity;
import com.margin.repository.product.ProductRepository;
import com.margin.repository.shop.ShopRepository;
import com.margin.service.product.converter.ProductEntityConverter;
import com.margin.service.product.converter.ProductModelConverter;
import com.margin.service.product.model.ProductCreationModel;
import com.margin.service.product.model.ProductModel;
import com.margin.service.product.model.ProductUpdateModel;
import com.margin.service.product.validator.ProductValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    private ProductEntityConverter productEntityConverter;

    private ShopRepository shopRepository;

    private ProductModelConverter productModelConverter;

    private ProductValidator productValidator;


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
    public ProductModel update(ProductUpdateModel productUpdateModel, Long id) {
        productValidator.productIsValid(productUpdateModel);
        ProductEntity productEntity = productRepository.findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new EntityNotFoundException("Product with id" +
                        productUpdateModel.getId() + " does not exist"));
        if (nameIsChanged(productEntity.getName(), productUpdateModel.getName())) {
            productValidator.productIsValid(productUpdateModel);
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

    @Override
    public List<ProductModel> getAll() {
        List<ProductEntity> products = productRepository.findAllOrdered();
        return products
                .stream()
                .map(productEntity -> productEntityConverter
                        .convert(productEntity))
                .collect(Collectors.toList());
    }

    public Boolean nameIsChanged(String oldName, String newName) {
        return !oldName.equalsIgnoreCase(newName);
    }
}
