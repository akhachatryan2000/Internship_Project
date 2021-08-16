package com.margin.repository.address.converter;

import com.margin.repository.address.entity.AddressCreationEntity;
import com.margin.repository.address.entity.AddressEntity;
import com.margin.repository.address.entity.AddressUpdateEntity;
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
        addressModel.setCity(addressEntity.getCity());
        addressModel.setCountry(addressEntity.getCountry());
        addressModel.setDistrict(addressEntity.getDistrict());
        addressModel.setPostCode(addressEntity.getPostCode());
        return addressModel;

    }

    public AddressCreationModel convert(AddressCreationEntity addressEntity) {
        if (addressEntity == null) {
            return null;
        }
        AddressCreationModel addressModel = new AddressCreationModel();
        addressModel.setAddressLine1(addressEntity.getAddressLine1());
        addressModel.setAddressLine2(addressEntity.getAddressLine2());
        addressModel.setCity(addressEntity.getCity());
        addressModel.setCountry(addressEntity.getCountry());
        addressModel.setDistrict(addressEntity.getDistrict());
        addressModel.setPostCode(addressEntity.getPostCode());
        return addressModel;

    }

    public AddressUpdateModel convert(AddressUpdateEntity addressEntity) {
        if (addressEntity == null) {
            return null;
        }
        AddressUpdateModel addressModel = new AddressUpdateModel();
        addressModel.setAddressLine1(addressEntity.getAddressLine1());
        addressModel.setAddressLine2(addressEntity.getAddressLine2());
        addressModel.setCity(addressEntity.getCity());
        addressModel.setCountry(addressEntity.getCountry());
        addressModel.setDistrict(addressEntity.getDistrict());
        addressModel.setPostCode(addressEntity.getPostCode());
        return addressModel;
    }

}
