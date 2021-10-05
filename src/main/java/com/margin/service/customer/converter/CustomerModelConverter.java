package com.margin.service.customer.converter;

import com.margin.controller.customer.dto.CustomerDTO;
import com.margin.entity.CustomerEntity;
import com.margin.service.customer.model.CustomerCreationModel;
import com.margin.service.customer.model.CustomerModel;
import com.margin.service.customer.model.CustomerUpdateModel;
import org.springframework.stereotype.Component;

@Component
public class CustomerModelConverter {

    public CustomerDTO convert(CustomerModel customerModel) {
        if (customerModel == null) {
            return null;
        }
        return new CustomerDTO(
                customerModel.getId(),
                customerModel.getName(),
                customerModel.getPhoneNumber(),
                customerModel.getAddressId(),
                customerModel.getBonus());
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
        if (customerUpdateModel == null && customerEntity == null) {
            return null;
        }
        customerEntity.setBonus(customerUpdateModel.getBonus());
        customerEntity.setName(customerUpdateModel.getName());
        customerEntity.setPhoneNumber(customerUpdateModel.getPhoneNumber());
        return customerEntity;
    }
}
