package com.margin.service.customer;

import com.margin.repository.address.AddressRepository;
import com.margin.repository.customer.CustomerRepository;
import com.margin.repository.customer.entity.CustomerEntity;
import com.margin.service.customer.converter.CustomerEntityConverter;
import com.margin.service.customer.converter.CustomerModelConverter;
import com.margin.service.customer.model.CustomerCreationModel;
import com.margin.service.customer.model.CustomerModel;
import com.margin.service.customer.model.CustomerUpdateModel;
import com.margin.service.customer.validator.CustomerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private final CustomerEntityConverter customerEntityConverter;

    @Autowired
    private CustomerModelConverter customerModelConverter;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CustomerValidator customerValidator;

    public CustomerService(CustomerRepository customerRepository, CustomerEntityConverter customerEntityConverter, CustomerModelConverter customerModelConverter, AddressRepository addressRepository) {
        this.customerRepository = customerRepository;
        this.customerEntityConverter = customerEntityConverter;
        this.customerModelConverter = customerModelConverter;
        this.addressRepository = addressRepository;
    }

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
        CustomerEntity customerExisting = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer with this id does not exist"));
        customerValidator.customerIsValid(customerUpdateModel);
        customerExisting = customerModelConverter.convert(customerUpdateModel, customerExisting);
        if (customerUpdateModel.getAddressId() != null) {
            customerExisting.setAddress(addressRepository.findById(customerUpdateModel.getAddressId())
                    .orElseThrow(() -> new EntityNotFoundException("Address with this id does not exist")));
        }
        customerExisting.setAddress(null);
        customerExisting = customerRepository.save(customerExisting);
        return customerEntityConverter.convert(customerExisting);
    }

    public Boolean delete(Long id) {
        customerRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Customer with this id does not exist"));
        customerRepository.deletedUpdate(id);
        return true;
    }
}
