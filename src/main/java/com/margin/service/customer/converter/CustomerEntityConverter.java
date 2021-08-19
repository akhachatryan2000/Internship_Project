package com.margin.service.customer.converter;

import com.margin.repository.address.AddressRepository;
import com.margin.repository.customer.entity.CustomerEntity;
import com.margin.repository.order.entity.OrderEntity;
import com.margin.service.customer.model.CustomerCreationModel;
import com.margin.service.customer.model.CustomerModel;
import com.margin.service.customer.model.CustomerUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerEntityConverter {

    @Autowired
    private AddressRepository addressRepository;

    public CustomerModel convert(CustomerEntity customerEntity) {
        if (customerEntity == null) {
            return null;
        }
        CustomerModel customerModel = new CustomerModel(
                customerEntity.getId(),
                customerEntity.getName(),
                customerEntity.getPhoneNumber(),
                customerEntity.getAddress().getId(),
                customerEntity.getBonus());
        return customerModel;
    }

    public CustomerEntity convert(CustomerModel customerModel) {
        if (customerModel == null) {
            return null;
        }
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(customerModel.getName());
        customerEntity.setBonus(customerModel.getBonus());
        customerEntity.setPhoneNumber(customerEntity.getPhoneNumber());
        customerEntity.setAddress(addressRepository.getById(customerModel.getAddressId()));
        return customerEntity;

    }

    public CustomerEntity convert(CustomerCreationModel customerCreationModel) {
        if (customerCreationModel == null) {
            return null;
        }

        CustomerEntity customer = new CustomerEntity();
        customer.setName(customerCreationModel.getName());
        customer.setAddress(addressRepository.getById(customerCreationModel.getAddressId()));
        customer.setBonus(customerCreationModel.getBonus());
        customer.setPhoneNumber(customerCreationModel.getPhoneNumber());
        return customer;


    }

    public CustomerEntity convert(CustomerUpdateModel customerUpdateModel, CustomerEntity customerEntity) {
        if (customerUpdateModel == null) {
            return null;
        }
        customerEntity.setBonus(customerUpdateModel.getBonus());
        customerEntity.setName(customerUpdateModel.getName());
        customerEntity.setAddress(addressRepository.getById(customerUpdateModel.getAddressId()));
        customerEntity.setPhoneNumber(customerUpdateModel.getPhoneNumber());
        return customerEntity;
    }


}

