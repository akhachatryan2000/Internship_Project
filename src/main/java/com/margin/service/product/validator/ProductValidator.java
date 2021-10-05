package com.margin.service.product.validator;

import com.margin.common.exception.product.ProductNotValidException;
import com.margin.common.exception.response.ExceptionCode;
import com.margin.repository.product.ProductRepository;
import com.margin.service.product.model.ProductCreationModel;
import com.margin.service.product.model.ProductUpdateModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
public class ProductValidator {

    private ProductRepository productRepository;

    public void productIsValid(ProductCreationModel productModel) {
        productIsUnique(productModel.getName());
        productHasDescription(productModel.getDescription());
        hasPrice(productModel.getPrice());

    }

    public void productIsValid(ProductUpdateModel productModel) {
        productIsUnique(productModel.getName());
        productHasDescription(productModel.getDescription());
        hasPrice(productModel.getPrice());
    }

    private void productHasDescription(String description) {
        if (description == null || description.isBlank()) {
            throw new ProductNotValidException("Product's description is mandatory", ExceptionCode.UUTI_45);
        }
    }

    private void hasPrice(BigDecimal price) {
        if (price == null || price.toString().isBlank()) {
            throw new ProductNotValidException("Product price is mandatory", ExceptionCode.UUTI_45);
        }
    }

    private void productIsUnique(String name) {
        if (name == null || name.isBlank()) {
            throw new ProductNotValidException("Product name is mandatory", ExceptionCode.UUTI_45);
        }
        if (productRepository.findByName(name).isPresent())
            throw new ProductNotValidException("Product already exists", ExceptionCode.UUTI_45);
    }
}

