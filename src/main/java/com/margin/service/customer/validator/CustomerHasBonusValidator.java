package com.margin.service.customer.validator;

import com.margin.common.exception.customer.CustomerNotValidException;
import com.margin.common.exception.response.ExceptionCode;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CustomerHasBonusValidator {

    public void customerHasBonus(BigDecimal bonus) {
        if (bonus == null) {
            throw new CustomerNotValidException("You should provide bonus field", ExceptionCode.UUTI_45);
        }
    }
}
