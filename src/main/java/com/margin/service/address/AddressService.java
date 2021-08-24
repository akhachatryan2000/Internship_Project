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

import javax.transaction.Transactional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressEntityConverter addressEntityConverter;

    @Autowired
    AddressModelConverter addressModelConverter;


    public AddressModel get(Long id) {
        AddressEntity addressEntity = addressRepository.getById(id);
        return addressEntityConverter.convert(addressEntity);
    }

    @Transactional
    public AddressModel create(AddressCreationModel addressCreationModel) {
        AddressEntity addressEntity = addressModelConverter.convert(addressCreationModel);
        AddressEntity address = addressRepository.save(addressEntity);
        return addressEntityConverter.convert(address);
    }

    @Transactional
    public AddressModel update(AddressUpdateModel addressUpdateModel, Long id) {
        AddressEntity addressEntity = addressRepository.getById(id);
        addressEntity = addressModelConverter.convert(addressUpdateModel, addressEntity);
        AddressEntity addressUpdated = addressRepository.save(addressEntity);
        return addressEntityConverter.convert(addressUpdated);
    }

    public Boolean delete(Long id) {
        addressRepository.deleteById(id);
        return true;
    }
}
