package com.margin.service.address.validator;

import com.margin.common.enums.Country;
import com.margin.common.exception.address.AddressNotValidException;
import com.margin.common.exception.response.ExceptionCode;
import com.margin.service.address.model.AddressCreationModel;
import com.margin.service.address.model.AddressUpdateModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AddressValidator {


    public void addressIsValid(AddressCreationModel addressModel) {
        addressHasAddressLine(addressModel.getAddressLine1());
        addressIncludesCity(addressModel.getCity());
        addressIncludesCountry(addressModel.getCountry());
        includesDistrict(addressModel.getDistrict());
    }

    public void addressIsValid(AddressUpdateModel addressModel) {
        addressHasAddressLine(addressModel.getAddressLine1());
        addressIncludesCity(addressModel.getCity());
        addressIncludesCountry(addressModel.getCountry());
        includesDistrict(addressModel.getDistrict());
    }

    private void addressHasAddressLine(String addressLine1) {
        if (addressLine1 == null) {
            throw new AddressNotValidException("AddressLine 1 is mandatory", ExceptionCode.UUTI_45);
        }
    }

    private void addressIncludesCity(String city) {
        if (city == null) {
            throw new AddressNotValidException("Address must include city", ExceptionCode.UUTI_45);
        }
    }

    private void addressIncludesCountry(Country country) {
        if (country == null) {
            throw new AddressNotValidException("Address must always include country", ExceptionCode.UUTI_45);
        }
    }

    private void includesDistrict(String district) {
        if (district == null) {
            throw new AddressNotValidException("Address must include district", ExceptionCode.UUTI_45);
        }
    }
}
