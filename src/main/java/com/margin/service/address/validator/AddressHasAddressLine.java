package com.margin.service.address.validator;

import com.margin.common.exception.address.AddressNotValidException;
import com.margin.common.exception.response.ExceptionCode;
import org.springframework.stereotype.Component;

@Component
public class AddressHasAddressLine {

    public void addressHasAddressLine(String addressLine1) {
        if (addressLine1 == null) {
            throw new AddressNotValidException("AddressLine 1 is mandatory", ExceptionCode.UUTI_45);
        }
    }
}
