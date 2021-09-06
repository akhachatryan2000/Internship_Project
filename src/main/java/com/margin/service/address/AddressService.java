package com.margin.service.address;

import com.margin.repository.AbstractEntity;
import com.margin.repository.address.AddressRepository;
import com.margin.repository.address.entity.AddressEntity;
import com.margin.service.address.converter.AddressEntityConverter;
import com.margin.service.address.converter.AddressModelConverter;
import com.margin.service.address.model.AddressCreationModel;
import com.margin.service.address.model.AddressModel;
import com.margin.service.address.model.AddressUpdateModel;
import com.margin.service.address.validator.AddressValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressEntityConverter addressEntityConverter;

    @Autowired
    private AddressModelConverter addressModelConverter;

    @Autowired
    private AddressValidator addressValidator;


    public AddressModel get(Long id) {
        AddressEntity addressEntity = addressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Address with this id does not exist"));
        return addressEntityConverter.convert(addressEntity);
    }

    @Transactional
    public AddressModel create(AddressCreationModel addressCreationModel) {
        addressValidator.addressIsValid(addressCreationModel);
        AddressEntity addressEntity = addressModelConverter.convert(addressCreationModel);
        AddressEntity address = addressRepository.save(addressEntity);
        return addressEntityConverter.convert(address);
    }

    @Transactional
    public AddressModel update(AddressUpdateModel addressUpdateModel, Long id) {
        AddressEntity addressEntity = addressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Address with this id does not exist"));
        addressValidator.addressIsValid(addressUpdateModel);
        addressEntity = addressModelConverter.convert(addressUpdateModel, addressEntity);
        AddressEntity addressUpdated = addressRepository.save(addressEntity);
        return addressEntityConverter.convert(addressUpdated);
    }

    public Boolean delete(Long id) {
        if (addressRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("There is no such address to delete");
        }
        addressRepository.deletedUpdate(id);
        return true;
    }
}
