package com.margin.service.product.validator;

import com.margin.common.exception.product.ProductNotValidException;
import com.margin.common.exception.response.ExceptionCode;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductHasPriceValidator {

    public void hasPrice(BigDecimal price) {
        if (price == null) {
            throw new ProductNotValidException("Product price is mandatory", ExceptionCode.UUTI_45);
        }
    }
}
