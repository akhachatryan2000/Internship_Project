package com.margin.service.product;

import com.margin.repository.product.ProductRepository;
import com.margin.repository.product.entity.ProductEntity;
import com.margin.repository.shop.entity.ShopRepository;
import com.margin.service.product.converter.ProductEntityConverter;
import com.margin.service.product.converter.ProductModelConverter;
import com.margin.service.product.model.ProductCreationModel;
import com.margin.service.product.model.ProductModel;
import com.margin.service.product.model.ProductUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductEntityConverter productEntityConverter;

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ProductModelConverter productModelConverter;

    public ProductModel get(Long id) {
        ProductEntity productEntity = productRepository.getById(id);
        return productEntityConverter.convert(productEntity);
    }

    @Transactional
    public ProductModel create(ProductCreationModel productCreationModel) {
        ProductEntity productEntity = productModelConverter.convert(productCreationModel);
        productEntity.setShopEntity(shopRepository.getById(productCreationModel.getShopId()));
        productEntity = productRepository.save(productEntity);
        return productEntityConverter.convert(productEntity);
    }

    @Transactional
    public ProductModel update(ProductUpdateModel productUpdateModel, Long id) {
        ProductEntity productEntity = productRepository.getById(id);
        productEntity = productModelConverter.convert(productUpdateModel, productEntity);
        productEntity = productRepository.save(productEntity);
        return productEntityConverter.convert(productEntity);
    }

    public Boolean delete(Long id) {
        productRepository.deleteById(id);
        return true;
    }
}
