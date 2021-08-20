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
        //here can be an exception
        AddressEntity addressEntity = addressRepository.getById(id);
        return addressEntityConverter.convert(addressEntity);
    }

    public AddressModel create(AddressCreationModel addressCreationModel) {
        AddressEntity addressEntity = addressEntityConverter.convert(addressCreationModel);
        AddressEntity address = addressRepository.save(addressEntity);
        return addressEntityConverter.convert(address);
    }

    public AddressModel update(AddressUpdateModel addressUpdateModel, Long id) {
        //here can be an exception
        AddressEntity addressEntity = addressRepository.getById(id);
        AddressEntity addressEntity1 = addressEntityConverter.convert(addressUpdateModel, addressEntity);
        AddressEntity addressUpdated = addressRepository.save(addressEntity1);
        return addressEntityConverter.convert(addressUpdated);
    }

    public Boolean delete(Long id) {
        //here can be an exception
        addressRepository.deleteById(id);
        return true;
    }
}
