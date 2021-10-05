package com.margin.service.address.converter;

import com.margin.entity.AddressEntity;
import com.margin.service.address.model.AddressModel;
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
}
