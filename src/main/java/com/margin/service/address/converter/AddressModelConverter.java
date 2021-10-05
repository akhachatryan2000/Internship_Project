package com.margin.service.address.converter;

import com.margin.controller.address.dto.AddressDTO;
import com.margin.entity.AddressEntity;
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
        return new AddressDTO(
                addressModel.getId(),
                addressModel.getCountry(),
                addressModel.getDistrict(),
                addressModel.getCity(),
                addressModel.getAddressLine1(),
                addressModel.getAddressLine2(),
                addressModel.getPostCode());
    }

    public AddressEntity convert(AddressCreationModel addressModel) {
        if (addressModel == null) {
            return null;
        }
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setPostCode(addressModel.getPostCode());
        addressEntity.setCountry(addressModel.getCountry());
        addressEntity.setAddressLine1(addressModel.getAddressLine1());
        addressEntity.setAddressLine2(addressModel.getAddressLine2());
        addressEntity.setCity(addressModel.getCity());
        addressEntity.setDistrict(addressModel.getDistrict());
        return addressEntity;
    }

    public AddressEntity convert(AddressUpdateModel addressUpdateModel, AddressEntity addressEntity) {
        if (addressUpdateModel == null && addressEntity == null) {
            return null;
        }
        addressEntity.setAddressLine1(addressUpdateModel.getAddressLine1());
        addressEntity.setAddressLine2(addressUpdateModel.getAddressLine2());
        addressEntity.setDistrict(addressUpdateModel.getDistrict());
        addressEntity.setCity(addressUpdateModel.getCity());
        addressEntity.setCountry(addressUpdateModel.getCountry());
        addressEntity.setPostCode(addressUpdateModel.getPostCode());
        return addressEntity;
    }
}
