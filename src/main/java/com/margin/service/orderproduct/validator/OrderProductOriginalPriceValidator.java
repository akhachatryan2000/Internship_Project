package com.margin.service.orderproduct.validator;


import com.margin.common.exception.product.ProductNotValidException;
import com.margin.common.exception.response.ExceptionCode;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;

@Component
public class OrderProductOriginalPriceValidator {

    public void hasOriginalPrice(BigDecimal originalPrice) {
        if (originalPrice == null) {
            throw new ProductNotValidException("Product must contain original price", ExceptionCode.UUTI_45);
        }
    }
}
