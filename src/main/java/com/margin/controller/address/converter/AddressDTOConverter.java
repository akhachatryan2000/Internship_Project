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
        if (addressDTO==null) {
            return null;
        }
        AddressModel addressModel = new AddressModel();
        addressModel.setId(addressDTO.getId());
        addressModel.setAddressLine1(addressDTO.getAddressLine1());
        addressModel.setAddressLine2(addressDTO.getAddressLine2());
        addressModel.setCity(addressDTO.getCity());
        addressModel.setCountry(addressDTO.getCountry());
        addressModel.setDistrict(addressDTO.getDistrict());
        addressModel.setPostCode(addressDTO.getPostCode());
        return addressModel;
    }


    public AddressCreationModel convert(AddressCreationDTO addressCreationDTO) {
        if (addressCreationDTO==null) {
            return null;
        }
        AddressCreationModel addressCreationModel = new AddressCreationModel();
        addressCreationModel.setAddressLine1(addressCreationDTO.getAddressLine1());
        addressCreationModel.setAddressLine2(addressCreationDTO.getAddressLine2());
        addressCreationModel.setCity(addressCreationDTO.getCity());
        addressCreationModel.setCountry(addressCreationDTO.getCountry());
        addressCreationModel.setDistrict(addressCreationDTO.getDistrict());
        addressCreationModel.setPostCode(addressCreationDTO.getPostCode());
        return addressCreationModel;

    }

    public AddressUpdateModel convert(AddressUpdateDTO updateDTO) {
        if (updateDTO==null) {
            return null;
        }
        AddressUpdateModel addressUpdateModel = new AddressUpdateModel();
        addressUpdateModel.setAddressLine1(updateDTO.getAddressLine1());
        addressUpdateModel.setAddressLine2(updateDTO.getAddressLine2());
        addressUpdateModel.setCity(updateDTO.getCity());
        addressUpdateModel.setPostCode(updateDTO.getPostCode());
        addressUpdateModel.setDistrict(updateDTO.getDistrict());
        addressUpdateModel.setCountry(updateDTO.getCountry());
        return addressUpdateModel;
    }
}
