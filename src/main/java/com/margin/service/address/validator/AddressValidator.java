package com.margin.service.address.validator;

import com.margin.common.enums.Country;
import com.margin.service.address.model.AddressCreationModel;
import com.margin.service.address.model.AddressUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressValidator {

    @Autowired
    private AddressHasAddressLine addressLine;

    @Autowired
    private AddressIncludesCityValidator cityValidator;

    @Autowired
    private AddressIncludesCountry includesCountry;

    @Autowired
    private AddressIncludesDistrictValidator includesDistrictValidator;

    public void addressIsValid(AddressCreationModel addressModel) {
        addressLine.addressHasAddressLine(addressModel.getAddressLine1());
        cityValidator.addressIncludesCity(addressModel.getCity());
        includesCountry.addressIncludesCountry(addressModel.getCountry());
        includesDistrictValidator.includesDistrict(addressModel.getDistrict());
    }

    public void addressIsValid(AddressUpdateModel addressModel) {
        addressLine.addressHasAddressLine(addressModel.getAddressLine1());
        cityValidator.addressIncludesCity(addressModel.getCity());
        includesCountry.addressIncludesCountry(addressModel.getCountry());
        includesDistrictValidator.includesDistrict(addressModel.getDistrict());
    }

}
