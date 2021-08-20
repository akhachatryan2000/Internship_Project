package com.margin.service.customer;

import com.margin.repository.address.AddressRepository;
import com.margin.repository.customer.CustomerRepository;
import com.margin.repository.customer.entity.CustomerEntity;
import com.margin.service.customer.converter.CustomerEntityConverter;
import com.margin.service.customer.model.CustomerCreationModel;
import com.margin.service.customer.model.CustomerModel;
import com.margin.service.customer.model.CustomerUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerEntityConverter customerEntityConverter;

    @Autowired
    private AddressRepository addressRepository;


    public CustomerModel get(Long id) {
        try {
            CustomerEntity customerEntity = customerRepository.getById(id);
            customerEntity.setAddress(addressRepository.getById(id));
            return customerEntityConverter.convert(customerEntity);
        } catch (EntityNotFoundException entityNotFoundException) {
            System.out.println("No such element");
        }
        return null;
    }

    public CustomerModel create(CustomerCreationModel customerCreationModel) {
        CustomerEntity customerCreated = customerEntityConverter.convert(customerCreationModel);
        if (customerCreationModel.getAddressId() != null) {
            customerCreated.setAddress(addressRepository.getById(customerCreationModel.getAddressId()));
        } else {
            customerCreationModel.setAddressId(null);
        }
        CustomerEntity customer = customerRepository.save(customerCreated);
        return customerEntityConverter.convert(customer);
    }

    public CustomerModel update(CustomerUpdateModel customerUpdateModel, Long id) {
        CustomerEntity customer = customerRepository.getById(id);
        CustomerEntity customerEntity = customerEntityConverter.convert(customerUpdateModel, customer);
        if (customerUpdateModel.getAddressId() != null) {
            customer.setAddress(addressRepository.getById(id));
        } else customer.setAddress(null);
        customer = customerRepository.save(customer);
        return customerEntityConverter.convert(customerEntity);
    }

    public Boolean delete(Long id) {
        customerRepository.deleteById(id);
        return true;
    }
}
