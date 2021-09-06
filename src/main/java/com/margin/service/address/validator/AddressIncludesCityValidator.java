package com.margin.service.address.validator;

import com.margin.common.exception.address.AddressNotValidException;
import com.margin.common.exception.response.ExceptionCode;
import org.springframework.stereotype.Component;

@Component
public class AddressIncludesCityValidator {

    public void addressIncludesCity(String city) {
        if (city == null) {
            throw new AddressNotValidException("Address must include city", ExceptionCode.UUTI_45);
        }
    }
}
