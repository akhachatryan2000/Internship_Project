package com.margin.service.order.validator;

import com.margin.common.exception.order.OrderNotValidException;
import com.margin.common.exception.response.ExceptionCode;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PaidFromBonusValidator {

    public void paidFromBonus(BigDecimal paidFromBonus) {
        if (paidFromBonus == null) {
            throw new OrderNotValidException("Provide paid from bonus field", ExceptionCode.UUTI_45);
        }
    }
}
