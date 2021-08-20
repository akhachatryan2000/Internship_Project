package com.margin.service.customer.converter;

import com.margin.repository.customer.entity.CustomerEntity;
import com.margin.service.customer.model.CustomerCreationModel;
import com.margin.service.customer.model.CustomerModel;
import com.margin.service.customer.model.CustomerUpdateModel;
import org.springframework.stereotype.Component;


@Component
public class CustomerEntityConverter {

    public CustomerModel convert(CustomerEntity customerEntity) {
        if (customerEntity == null) {
            return null;
        }
        return new CustomerModel(
                customerEntity.getId(),
                customerEntity.getName(),
                customerEntity.getPhoneNumber(),
                // if address is null then set null
                customerEntity.getAddress().getId(),
                customerEntity.getBonus());
    }

    public CustomerEntity convert(CustomerCreationModel customerCreationModel) {
        if (customerCreationModel == null) {
            return null;
        }
        CustomerEntity customer = new CustomerEntity();
        customer.setName(customerCreationModel.getName());
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
        customerEntity.setPhoneNumber(customerUpdateModel.getPhoneNumber());
        return customerEntity;
    }
}

