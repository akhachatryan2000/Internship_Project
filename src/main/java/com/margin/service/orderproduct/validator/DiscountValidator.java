package com.margin.service.orderproduct.validator;

import com.margin.common.exception.orderproduct.OrderProductNotValidException;
import com.margin.common.exception.response.ExceptionCode;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DiscountValidator {

    public void hasDiscount(BigDecimal discount){
        if (discount == null) {
            throw new OrderProductNotValidException("Provide discount field", ExceptionCode.UUTI_45);
        }
    }
}
