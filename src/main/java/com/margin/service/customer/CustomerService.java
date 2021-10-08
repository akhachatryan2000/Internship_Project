package com.margin.service.customer;

import com.margin.entity.CustomerEntity;
import com.margin.repository.address.AddressRepository;
import com.margin.repository.customer.CustomerRepository;
import com.margin.service.customer.converter.CustomerEntityConverter;
import com.margin.service.customer.converter.CustomerModelConverter;
import com.margin.service.customer.model.CustomerCreationModel;
import com.margin.service.customer.model.CustomerModel;
import com.margin.service.customer.model.CustomerUpdateModel;
import com.margin.service.customer.validator.CustomerValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;

    private CustomerEntityConverter customerEntityConverter;

    private CustomerModelConverter customerModelConverter;

    private AddressRepository addressRepository;

    private CustomerValidator customerValidator;


    public CustomerModel get(Long id) {
        CustomerEntity customerEntity = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer with id " + id + " does not exist"));
        return customerEntityConverter.convert(customerEntity);
    }

    @Transactional
    public CustomerModel create(CustomerCreationModel customerCreationModel) {
        customerValidator.customerIsValid(customerCreationModel);
        CustomerEntity customer = customerModelConverter.convert(customerCreationModel);
        if (customerCreationModel.getAddressId() != null) {
            customer.setAddress(addressRepository.findById(customerCreationModel.getAddressId())
                    .orElseThrow(() -> new EntityNotFoundException("Address with this id does not exist")));
        } else {
            customer.setAddress(null);
        }
        CustomerEntity customerCreated = customerRepository.save(customer);
        return customerEntityConverter.convert(customerCreated);
    }

    @Transactional
    public CustomerModel update(CustomerUpdateModel customerUpdateModel, Long id) {
        customerValidator.customerIsValid(customerUpdateModel);
        CustomerEntity customerExisting = customerRepository.findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer with this id does not exist"));
        customerExisting = customerModelConverter.convert(customerUpdateModel, customerExisting);
        if (customerUpdateModel.getAddressId() != null) {
            customerExisting.setAddress(addressRepository.findById(customerUpdateModel.getAddressId())
                    .orElseThrow(() -> new EntityNotFoundException("Address with this id does not exist")));
        } else {
            customerExisting.setAddress(null);
        }
        customerExisting = customerRepository.saveAndFlush(customerExisting);
        return customerEntityConverter.convert(customerExisting);
    }

    public Boolean delete(Long id) {
        customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer with this id does not exist"));
        customerRepository.deletedUpdate(id);
        return true;
    }

    public List<CustomerModel> getAll() {
        List<CustomerEntity> customerEntities = customerRepository.findAllOrdered();
        return customerEntities
                .stream()
                .map(customerEntity -> customerEntityConverter.convert(customerEntity))
                .collect(Collectors.toList());
    }
}
