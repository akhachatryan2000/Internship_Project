package com.margin.service.address.validator;

import com.margin.common.enums.Country;
import com.margin.common.exception.address.AddressNotValidException;
import com.margin.common.exception.response.ExceptionCode;
import org.springframework.stereotype.Component;

@Component
public class AddressIncludesCountry {

    public void addressIncludesCountry(Country country) {
        if (country == null) {
            throw new AddressNotValidException("Address must always include country", ExceptionCode.UUTI_45);
        }
    }
}

