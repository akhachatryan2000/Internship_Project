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
        if (addressModel==null) {
            return null;
        }
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(addressModel.getId());
        addressDTO.setAddressLine1(addressModel.getAddressLine1());
        addressDTO.setAddressLine2(addressModel.getAddressLine2());
        addressDTO.setCity(addressModel.getCity());
        addressDTO.setCountry(addressModel.getCountry());
        addressDTO.setDistrict(addressModel.getDistrict());
        addressDTO.setPostCode(addressModel.getPostCode());
        return addressDTO;
    }


    public AddressCreationDTO convert(AddressCreationModel addressModel) {
        if (addressModel==null) {
            return null;
        }
        AddressCreationDTO addressDTO = new AddressCreationDTO();
        addressDTO.setAddressLine1(addressModel.getAddressLine1());
        addressDTO.setAddressLine2(addressModel.getAddressLine2());
        addressDTO.setCity(addressModel.getCity());
        addressDTO.setCountry(addressModel.getCountry());
        addressDTO.setDistrict(addressModel.getDistrict());
        addressDTO.setPostCode(addressModel.getPostCode());
        return addressDTO;


    }

    public AddressUpdateDTO convert(AddressUpdateModel addressModel) {
        if (addressModel==null) {
            return null;
        }
       AddressUpdateDTO addressDTO= new AddressUpdateDTO();
        addressDTO.setAddressLine1(addressModel.getAddressLine1());
        addressDTO.setAddressLine2(addressModel.getAddressLine2());
        addressDTO.setCity(addressModel.getCity());
        addressDTO.setCountry(addressModel.getCountry());
        addressDTO.setDistrict(addressModel.getDistrict());
        addressDTO.setPostCode(addressModel.getPostCode());
        return addressDTO;

    }

}
