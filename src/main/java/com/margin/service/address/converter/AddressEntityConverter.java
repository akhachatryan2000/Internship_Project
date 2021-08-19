package com.margin.service.address.converter;

import com.margin.repository.address.entity.AddressEntity;
import com.margin.service.address.model.AddressCreationModel;
import com.margin.service.address.model.AddressModel;
import com.margin.service.address.model.AddressUpdateModel;
import org.springframework.stereotype.Component;

@Component
public class AddressEntityConverter {

    // TODO: 19.08.21 review the convertsion methods from addresModel to addressEntity 

    public AddressModel convert(AddressEntity addressEntity) {
        if (addressEntity == null) {
            return null;
        }
        AddressModel addressModel = new AddressModel(
                addressEntity.getId(),
                addressEntity.getCountry(),
                addressEntity.getDistrict(),
                addressEntity.getCity(),
                addressEntity.getAddressLine1(),
                addressEntity.getAddressLine2(),
                addressEntity.getPostCode()
        );

        return addressModel;
    }

    public AddressEntity convert(AddressModel addressModel) {
        if (addressModel == null) {
            return null;
        }
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCity(addressEntity.getCity());
        addressEntity.setCountry(addressModel.getCountry());
        addressEntity.setDistrict(addressModel.getDistrict());
        addressEntity.setAddressLine1(addressModel.getAddressLine1());
        addressEntity.setAddressLine2(addressModel.getAddressLine2());
        addressEntity.setPostCode(addressModel.getPostCode());
        return addressEntity;
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
