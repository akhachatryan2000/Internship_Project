package com.margin.service.product;

import com.margin.repository.product.ProductRepository;
import com.margin.repository.product.converter.ProductEntityConverter;
import com.margin.repository.product.entity.ProductEntity;
import com.margin.service.product.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    private ProductEntityConverter productEntityConverter;


    public ProductModel getProduct(int id) {
        ProductEntity productEntity = productRepository.getById(id);
        return productEntityConverter.convert(productEntity);


    }

}
