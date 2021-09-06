package com.margin.service.product.validator;

import com.margin.service.product.model.ProductCreationModel;
import com.margin.service.product.model.ProductUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductValidator {

    @Autowired
    private ProductHasDescriptionValidator productHasDescriptionValidator;

    @Autowired
    private ProductIsUniqueValidator productIsUniqueValidator;

    @Autowired
    private ProductHasPriceValidator hasPriceValidator;

    public void productIsValid(ProductCreationModel productModel) {
        productIsUniqueValidator.productIsUnique(productModel.getName());
        productHasDescriptionValidator.productHasDescription(productModel.getDescription());
        hasPriceValidator.hasPrice(productModel.getPrice());

    }

    public void productIsValid(ProductUpdateModel productModel) {
        productIsUniqueValidator.productIsUnique(productModel.getName());
        productHasDescriptionValidator.productHasDescription(productModel.getDescription());
        hasPriceValidator.hasPrice(productModel.getPrice());

    }

}

