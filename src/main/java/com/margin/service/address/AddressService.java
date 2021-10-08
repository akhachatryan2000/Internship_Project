package com.margin.service.address;

import com.margin.entity.AddressEntity;
import com.margin.repository.address.AddressRepository;
import com.margin.service.address.converter.AddressEntityConverter;
import com.margin.service.address.converter.AddressModelConverter;
import com.margin.service.address.model.AddressCreationModel;
import com.margin.service.address.model.AddressModel;
import com.margin.service.address.model.AddressUpdateModel;
import com.margin.service.address.validator.AddressValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AddressService {

    private AddressRepository addressRepository;

    private AddressEntityConverter addressEntityConverter;

    private AddressModelConverter addressModelConverter;

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
        AddressEntity addressEntity = addressRepository.findByIdAndDeletedIsFalse(id)
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

    public List<AddressModel> getAll() {
        List<AddressEntity> addressEntities = addressRepository.findAllByOrdered();
        return addressEntities
                .stream()
                .map(addressEntity -> addressEntityConverter.convert(addressEntity))
                .collect(Collectors.toList());
    }
}
