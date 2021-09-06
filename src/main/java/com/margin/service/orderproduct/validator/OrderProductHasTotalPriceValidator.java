package com.margin.service.orderproduct.validator;

import com.margin.common.exception.product.ProductNotValidException;
import com.margin.common.exception.response.ExceptionCode;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrderProductHasTotalPriceValidator {

    public void hasTotalPrice(BigDecimal totalPrice) {
        if (totalPrice == null) {
            throw new ProductNotValidException("Product must have total price", ExceptionCode.UUTI_45);
        }
    }
}
