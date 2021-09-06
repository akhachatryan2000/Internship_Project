package com.margin.service.customer.validator;

import com.margin.common.exception.customer.CustomerNotValidException;
import com.margin.common.exception.response.ExceptionCode;
import org.springframework.stereotype.Component;

@Component
public class CustomerHasNameValidator {

    public void customerHasName(String name) {
        if (name == null) {
            throw new CustomerNotValidException("Customer's name is mandatory", ExceptionCode.UUTI_45);
        }
    }
}
