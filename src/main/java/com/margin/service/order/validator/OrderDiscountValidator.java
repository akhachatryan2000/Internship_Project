package com.margin.service.order.validator;

import com.margin.common.exception.order.OrderNotValidException;
import com.margin.common.exception.response.ExceptionCode;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrderDiscountValidator {

    public void hasOrderDiscount(BigDecimal discount) {
        if (discount == null) {
            throw new OrderNotValidException("Provide order discount", ExceptionCode.UUTI_45);
        }
    }
}
