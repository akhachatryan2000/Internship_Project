package com.margin.controller.address.converter;

import com.margin.controller.address.dto.AddressCreationDTO;
import com.margin.controller.address.dto.AddressDTO;
import com.margin.controller.address.dto.AddressUpdateDTO;
import com.margin.service.address.model.AddressCreationModel;
import com.margin.service.address.model.AddressModel;
import com.margin.service.address.model.AddressUpdateModel;
import org.springframework.stereotype.Component;

@Component
public class AddressDTOConverter {

    public AddressModel convert(AddressDTO addressDTO) {
        if (addressDTO == null) {
            return null;
        }
        return new AddressModel(
                addressDTO.getId(),
                addressDTO.getCountry(),
                addressDTO.getDistrict(),
                addressDTO.getCity(),
                addressDTO.getAddressLine1(),
                addressDTO.getAddressLine2(),
                addressDTO.getPostCode());
    }

    public AddressCreationModel convert(AddressCreationDTO addressCreationDTO) {
        if (addressCreationDTO == null) {
            return null;
        }
        return new AddressCreationModel(
                addressCreationDTO.getCountry(),
                addressCreationDTO.getDistrict(),
                addressCreationDTO.getCity(),
                addressCreationDTO.getAddressLine1(),
                addressCreationDTO.getAddressLine2(),
                addressCreationDTO.getPostCode());
    }

    public AddressUpdateModel convert(AddressUpdateDTO addressUpdateDTO) {
        if (addressUpdateDTO == null) {
            return null;
        }
        return new AddressUpdateModel(
                addressUpdateDTO.getId(),
                addressUpdateDTO.getCountry(),
                addressUpdateDTO.getDistrict(),
                addressUpdateDTO.getCity(),
                addressUpdateDTO.getAddressLine1(),
                addressUpdateDTO.getAddressLine2(),
                addressUpdateDTO.getPostCode());
    }
}
