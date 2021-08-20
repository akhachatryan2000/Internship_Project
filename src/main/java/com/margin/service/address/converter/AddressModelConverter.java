package com.margin.service.address.converter;

import com.margin.controller.address.dto.AddressCreationDTO;
import com.margin.controller.address.dto.AddressDTO;
import com.margin.controller.address.dto.AddressUpdateDTO;
import com.margin.service.address.model.AddressCreationModel;
import com.margin.service.address.model.AddressModel;
import com.margin.service.address.model.AddressUpdateModel;
import org.springframework.stereotype.Component;

@Component
public class AddressModelConverter {

    public AddressDTO convert(AddressModel addressModel) {
        if (addressModel == null) {
            return null;
        }
        return new AddressDTO(addressModel.getId(),
                addressModel.getCountry(),
                addressModel.getDistrict(),
                addressModel.getCity(),
                addressModel.getAddressLine1(),
                addressModel.getAddressLine2(),
                addressModel.getPostCode());
    }


    public AddressCreationDTO convert(AddressCreationModel addressModel) {
        if (addressModel == null) {
            return null;
        }
        return new AddressCreationDTO(
                addressModel.getCountry(),
                addressModel.getDistrict(),
                addressModel.getCity(),
                addressModel.getAddressLine1(),
                addressModel.getAddressLine2(),
                addressModel.getPostCode());
    }

    public AddressUpdateDTO convert(AddressUpdateModel addressModel) {
        if (addressModel == null) {
            return null;
        }
        return new AddressUpdateDTO(
                addressModel.getId(),
                addressModel.getCountry(),
                addressModel.getDistrict(),
                addressModel.getCity(),
                addressModel.getAddressLine1(),
                addressModel.getAddressLine2(),
                addressModel.getPostCode());
    }
}
