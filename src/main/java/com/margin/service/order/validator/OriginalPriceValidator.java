package com.margin.service.order.validator;

import com.margin.common.exception.order.OrderNotValidException;
import com.margin.common.exception.response.ExceptionCode;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OriginalPriceValidator {

    public void hasOriginalPrice(BigDecimal price) {
        if (price == null) {
            throw new OrderNotValidException("Provide original price", ExceptionCode.UUTI_45);
        }
    }
}
