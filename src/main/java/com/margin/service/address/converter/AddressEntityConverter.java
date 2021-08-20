package com.margin.service.address.converter;

import com.margin.repository.address.entity.AddressEntity;
import com.margin.service.address.model.AddressCreationModel;
import com.margin.service.address.model.AddressModel;
import com.margin.service.address.model.AddressUpdateModel;
import org.springframework.stereotype.Component;

@Component
public class AddressEntityConverter {

    public AddressModel convert(AddressEntity addressEntity) {
        if (addressEntity == null) {
            return null;
        }
        return new AddressModel(
                addressEntity.getId(),
                addressEntity.getCountry(),
                addressEntity.getDistrict(),
                addressEntity.getCity(),
                addressEntity.getAddressLine1(),
                addressEntity.getAddressLine2(),
                addressEntity.getPostCode());
    }

    public AddressEntity convert(AddressCreationModel addressModel) {
        if (addressModel == null) {
            return null;
        }
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setPostCode(addressModel.getPostCode());
        addressEntity.setCountry(addressModel.getCountry());
        addressEntity.setAddressLine1(addressModel.getAddressLine1());
        addressEntity.setAddressLine2(addressEntity.getAddressLine2());
        addressEntity.setCity(addressModel.getCity());
        return addressEntity;
    }

    public AddressEntity convert(AddressUpdateModel addressUpdateModel, AddressEntity addressEntity) {
        if (addressUpdateModel == null) {
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
