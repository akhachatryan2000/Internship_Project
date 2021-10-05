package com.margin.service.customer.converter;

import com.margin.entity.CustomerEntity;
import com.margin.service.customer.model.CustomerModel;
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
                customerEntity.getAddress() == null ? null : customerEntity.getAddress().getId(),
                customerEntity.getBonus());
    }
}

