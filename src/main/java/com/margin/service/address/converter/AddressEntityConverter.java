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
        AddressModel addressModel = new AddressModel();
        addressModel.setId(addressEntity.getId());
        addressModel.setAddressLine1(addressEntity.getAddressLine1());
        addressModel.setAddressLine2(addressEntity.getAddressLine2());
        addressModel.setDistrict(addressEntity.getDistrict());
        addressModel.setCountry(addressEntity.getCountry());
        addressModel.setPostCode(addressEntity.getPostCode());
        addressModel.setCity(addressEntity.getCity());
        return addressModel;
    }

    public AddressEntity convert(AddressModel addressModel) {
        if (addressModel == null) {
            return null;
        }
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setDistrict(addressModel.getDistrict());
        addressEntity.setAddressLine1(addressEntity.getAddressLine1());
        addressEntity.setAddressLine2(addressModel.getAddressLine2());
        addressEntity.setId(addressModel.getId());
        addressEntity.setCity(addressModel.getCity());
        addressEntity.setCountry(addressModel.getCountry());
        addressEntity.setPostCode(addressModel.getPostCode());
        return addressEntity;
    }

    public AddressEntity convert(AddressCreationModel addressModel) {
        if (addressModel == null) {
            return null;
        }
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setDistrict(addressModel.getDistrict());
        addressEntity.setAddressLine1(addressEntity.getAddressLine1());
        addressEntity.setAddressLine2(addressModel.getAddressLine2());
        addressEntity.setCity(addressModel.getCity());
        addressEntity.setCountry(addressModel.getCountry());
        addressEntity.setPostCode(addressModel.getPostCode());
        return addressEntity;
    }

    public AddressEntity convert(AddressUpdateModel addressUpdateModel, AddressEntity addressEntity) {
        if (addressUpdateModel == null) {
            return null;
        }
        addressEntity.setId(addressUpdateModel.getId());
        addressEntity.setAddressLine1(addressUpdateModel.getAddressLine1());
        addressEntity.setAddressLine2(addressUpdateModel.getAddressLine2());
        addressEntity.setDistrict(addressUpdateModel.getDistrict());
        addressEntity.setCity(addressUpdateModel.getCity());
        addressEntity.setCountry(addressUpdateModel.getCountry());
        addressEntity.setPostCode(addressUpdateModel.getPostCode());
        return addressEntity;
    }

}
