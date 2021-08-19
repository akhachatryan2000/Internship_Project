package com.margin.service.customer.converter;

import com.margin.repository.customer.entity.CustomerEntity;
import com.margin.repository.order.entity.OrderEntity;
import com.margin.service.customer.model.CustomerCreationModel;
import com.margin.service.customer.model.CustomerModel;
import com.margin.service.customer.model.CustomerUpdateModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerEntityConverter {

    public CustomerModel convert(CustomerEntity customerEntity) {
        if (customerEntity == null) {
            return null;
        }
        CustomerModel customerModel = new CustomerModel();
        customerModel.setId(customerEntity.getId());
        customerModel.setBonus(customerEntity.getBonus());
        customerModel.setPhoneNumber(customerEntity.getPhoneNumber());
        customerModel.setName(customerEntity.getName());
        customerModel.setAddressId(customerModel.getAddressId());
        // customerModel.setOrderIds(customerEntity.getOrders());
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
        customerEntity.setId(customerModel.getId());
        customerEntity.setAddress(customerEntity.getAddress());
        // customerEntity.setOrders(customerModel.getOrderIds());
        return customerEntity;

    }

    public CustomerEntity convert(CustomerCreationModel customerCreationModel) {
        if (customerCreationModel == null) {
            return null;
        }
        CustomerEntity customer = new CustomerEntity();
        customer.setName(customerCreationModel.getName());
        //customer.setAddress(customerCreationModel.getAddress());
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
        // customerEntity.setAddress(customerUpdateModel.getAddressId());
        //customerEntity.setOrders(customerUpdateModel.getOrderIds());
        return customerEntity;
    }


}

