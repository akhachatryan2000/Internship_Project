package com.margin.service.customer.validator;

import com.margin.common.exception.customer.CustomerNotValidException;
import com.margin.common.exception.response.ExceptionCode;
import org.springframework.stereotype.Component;

@Component
public class CustomerHasPhoneNumber {

    public void hasPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            throw new CustomerNotValidException("Phone number is mandatory", ExceptionCode.UUTI_45);
        }
    }
}
