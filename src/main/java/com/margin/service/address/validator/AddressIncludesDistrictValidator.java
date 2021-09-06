package com.margin.service.address.validator;

import com.margin.common.exception.address.AddressNotValidException;
import com.margin.common.exception.response.ExceptionCode;
import org.springframework.stereotype.Component;

@Component
public class AddressIncludesDistrictValidator {

    public void includesDistrict(String district) {
        if (district == null) {
            throw new AddressNotValidException("Address must include district", ExceptionCode.UUTI_45);
        }
    }
}
