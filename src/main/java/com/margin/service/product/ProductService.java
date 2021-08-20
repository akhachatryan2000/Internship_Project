package com.margin.service.product;

import com.margin.repository.product.ProductRepository;
import com.margin.repository.product.entity.ProductEntity;
import com.margin.service.product.converter.ProductEntityConverter;
import com.margin.service.product.model.ProductCreationModel;
import com.margin.service.product.model.ProductModel;
import com.margin.service.product.model.ProductUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductEntityConverter productEntityConverter;


    public ProductModel get(Long id) {
        ProductEntity productEntity = productRepository.getById(id);
        return productEntityConverter.convert(productEntity);
    }

    public ProductModel create(ProductCreationModel productCreationModel) {
        ProductEntity productEntity = productEntityConverter.convert(productCreationModel);
        // set shop id
        ProductEntity productCreated = productRepository.save(productEntity);
        return productEntityConverter.convert(productCreated);
    }

    public ProductModel update(ProductUpdateModel productUpdateModel, Long id) {
        ProductEntity productEntity = productRepository.getById(id);
        ProductEntity orderEntity1 = productEntityConverter.convert(productUpdateModel, productEntity);
        return productEntityConverter.convert(orderEntity1);
    }

    public Boolean delete(Long id) {
        productRepository.deleteById(id);
        return true;
    }
}
