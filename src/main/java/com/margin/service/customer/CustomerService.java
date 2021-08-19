package com.margin.service.customer;


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


    public CustomerModel get(Long id) {
        try {
            CustomerEntity customerEntity = customerRepository.getById(id);
            CustomerModel customerModel = customerEntityConverter.convert(customerEntity);
            return customerModel;
        } catch (EntityNotFoundException entityNotFoundException) {
            System.out.println("No such element");
        }
        return null;
    }

    public CustomerModel create(CustomerCreationModel customerCreationModel) {
        CustomerEntity customerCreated = customerEntityConverter.convert(customerCreationModel);
        CustomerEntity customer = customerRepository.save(customerCreated);
        CustomerModel customerModel = customerEntityConverter.convert(customer);
        return customerModel;
    }

    public CustomerModel update(CustomerUpdateModel customerUpdateModel, Long id) {
        try {
            CustomerEntity customer = customerRepository.getById(id);
            CustomerEntity customerEntity = customerEntityConverter.convert(customerUpdateModel, customer);
            CustomerModel customerModel = customerEntityConverter.convert(customerEntity);
            return customerModel;
        } catch (EntityNotFoundException exception) {
            System.out.println("No such element");
        }
        return null;
    }

    public Boolean delete(Long id) {
        try {
            customerRepository.deleteById(id);
            return true;
        } catch (EntityNotFoundException exception) {
            System.out.println("There is no such element");
        }
        return null;
    }
}
