package com.margin.service.order.validator;

import com.margin.common.exception.order.OrderNotValidException;
import com.margin.common.exception.response.ExceptionCode;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrderHasTotalPrice {

    public void orderHasTotalPrice(BigDecimal price) {
        if (price == null) {
            throw new OrderNotValidException("Order price is mandatory", ExceptionCode.UUTI_45);
        }
    }
}
