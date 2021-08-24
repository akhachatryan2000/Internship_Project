package com.margin.service.customer;

import com.margin.repository.address.AddressRepository;
import com.margin.repository.customer.CustomerRepository;
import com.margin.repository.customer.entity.CustomerEntity;
import com.margin.service.customer.converter.CustomerEntityConverter;
import com.margin.service.customer.converter.CustomerModelConverter;
import com.margin.service.customer.model.CustomerCreationModel;
import com.margin.service.customer.model.CustomerModel;
import com.margin.service.customer.model.CustomerUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public CustomerService(CustomerRepository customerRepository, CustomerEntityConverter customerEntityConverter, CustomerModelConverter customerModelConverter, AddressRepository addressRepository) {
        this.customerRepository = customerRepository;
        this.customerEntityConverter = customerEntityConverter;
        this.customerModelConverter = customerModelConverter;
        this.addressRepository = addressRepository;
    }

    public CustomerModel get(Long id) {
        CustomerEntity customerEntity = customerRepository.getById(id);
        return customerEntityConverter.convert(customerEntity);
    }

    @Transactional
    public CustomerModel create(CustomerCreationModel customerCreationModel) {
        CustomerEntity customer = customerModelConverter.convert(customerCreationModel);
        if (customerCreationModel.getAddressId() != null) {
            customer.setAddress(addressRepository.getById(customerCreationModel.getAddressId()));
        } else {
            customer.setAddress(null);
        }
        CustomerEntity customerCreated = customerRepository.save(customer);
        return customerEntityConverter.convert(customerCreated);
    }

    @Transactional
    public CustomerModel update(CustomerUpdateModel customerUpdateModel, Long id) {
        System.out.println(id);
        CustomerEntity customerExisting = null;
        customerExisting = customerRepository.getById(id);
        customerExisting = customerModelConverter.convert(customerUpdateModel, customerExisting);
        if (customerUpdateModel.getAddressId() != null) {
            customerExisting.setAddress(addressRepository.getById(customerUpdateModel.getAddressId()));
        } else customerExisting.setAddress(null);
        customerExisting = customerRepository.save(customerExisting);
        return customerEntityConverter.convert(customerExisting);
    }

    public Boolean delete(Long id) {
        customerRepository.deleteById(id);
        return true;
    }
}
