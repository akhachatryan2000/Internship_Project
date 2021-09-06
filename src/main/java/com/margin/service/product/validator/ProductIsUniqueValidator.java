package com.margin.service.product.validator;

import com.margin.common.exception.product.ProductNotValidException;
import com.margin.common.exception.response.ExceptionCode;
import com.margin.repository.product.ProductRepository;
import com.margin.repository.product.entity.ProductEntity;
import com.margin.service.product.converter.ProductModelConverter;
import com.margin.service.product.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductIsUniqueValidator {

    @Autowired
    private ProductRepository productRepository;

    public void productIsUnique(String name) {
        if (name == null) {
            throw new ProductNotValidException("Product name is mandatory", ExceptionCode.UUTI_45);
        }
        if (productRepository.findByName(name).isPresent())
            throw new ProductNotValidException("Product already exists", ExceptionCode.UUTI_45);
    }
}


