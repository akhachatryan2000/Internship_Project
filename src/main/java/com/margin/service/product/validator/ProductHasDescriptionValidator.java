package com.margin.service.product.validator;

import com.margin.common.exception.product.ProductNotValidException;
import com.margin.common.exception.response.ExceptionCode;
import org.springframework.stereotype.Component;

@Component
public class ProductHasDescriptionValidator {

    public void productHasDescription(String description) {
        if (description == null || description.isBlank()) {
            throw new ProductNotValidException("Product's description is mandatory", ExceptionCode.UUTI_45);
        }
    }
}
