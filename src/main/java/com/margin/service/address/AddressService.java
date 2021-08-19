package com.margin.service.address;

import com.margin.repository.address.AddressRepository;
import com.margin.repository.address.entity.AddressEntity;
import com.margin.service.address.converter.AddressEntityConverter;
import com.margin.service.address.converter.AddressModelConverter;
import com.margin.service.address.model.AddressCreationModel;
import com.margin.service.address.model.AddressModel;
import com.margin.service.address.model.AddressUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressEntityConverter addressEntityConverter;


    @Autowired
    AddressModelConverter addressModelConverter;


    public AddressModel get(Long id) {
        try {
            AddressEntity addressEntity = addressRepository.getById(id);
            AddressModel addressModel = addressEntityConverter.convert(addressEntity);
            return addressModel;
        } catch (NoSuchFieldError error) {
            System.out.println("The address does not exist");
        }
        return null;
    }

    public AddressModel create(AddressCreationModel addressCreationModel) {
        AddressEntity addressEntity = addressEntityConverter.convert(addressCreationModel);
        AddressEntity address = addressRepository.save(addressEntity);
        return addressEntityConverter.convert(address);
    }

    public AddressModel update(AddressUpdateModel addressUpdateModel, Long id) {
        AddressEntity addressEntity = addressRepository.getById(id);
        AddressEntity addressEntity1 = addressEntityConverter.convert(addressUpdateModel, addressEntity);
        AddressEntity addressUpdated = addressRepository.save(addressEntity1);
        AddressModel addressModel = addressEntityConverter.convert(addressUpdated);
        return addressModel;
    }

    public Boolean delete(Long id) {
        try {
            addressRepository.deleteById(id);
            return true;
        } catch (IllegalArgumentException exception) {
            System.out.println("Such element does not exist");
        }
        return null;
    }
}
