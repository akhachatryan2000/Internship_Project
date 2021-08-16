package com.margin.repository.customer.converter;

import com.margin.repository.address.converter.AddressEntityConverter;
import com.margin.repository.address.entity.AddressEntity;
import com.margin.repository.customer.entity.CustomerCreationEntity;
import com.margin.repository.customer.entity.CustomerEntity;
import com.margin.repository.customer.entity.CustomerUpdateEntity;
import com.margin.repository.order.converter.OrderEntityConverter;
import com.margin.repository.order.entity.OrderCreationEntity;
import com.margin.repository.order.entity.OrderEntity;
import com.margin.repository.order.entity.OrderUpdateEntity;
import com.margin.service.address.model.AddressModel;
import com.margin.service.address.model.AddressUpdateModel;
import com.margin.service.customer.model.CustomerCreationModel;
import com.margin.service.customer.model.CustomerModel;
import com.margin.service.customer.model.CustomerUpdateModel;
import com.margin.service.order.model.OrderCreationModel;
import com.margin.service.order.model.OrderModel;
import com.margin.service.order.model.OrderUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerEntityConverter {
    @Autowired
    private AddressEntityConverter addressEntityConverter;
    @Autowired
    private OrderEntityConverter orderEntityConverter;
    @Autowired
    private CustomerEntityConverter customerEntityConverter;

    public CustomerModel convert(CustomerEntity customerEntity) {
        if (customerEntity == null) {
            return null;
        }
        CustomerModel customerModel = new CustomerModel();
        customerModel.setId(customerEntity.getId());
        customerModel.setName(customerEntity.getName());
        customerModel.setBonus(customerEntity.getBonus());
        customerModel.setPhoneNumber(customerEntity.getPhoneNumber());
        AddressModel addressModel = addressEntityConverter.convert(customerEntity.getAddress());
        customerModel.setAddressModel(addressModel);
        customerModel.setOrders(customerEntityConverter.convert(customerEntity.getOrders(), customerEntity));
        return customerModel;
    }

    public List<OrderModel> convert(List<OrderEntity> orderEntities, CustomerEntity customerEntity) {
        if (orderEntities == null) {
            return new ArrayList<>();
        }
        List<OrderModel> orderModels = customerEntity.getOrders()
                .stream().map(o -> orderEntityConverter.convert(o)).collect(Collectors.toList());
        return orderModels;
    }

    public CustomerCreationModel convert(CustomerCreationEntity customerEntity) {
        if (customerEntity == null) {
            return null;
        }
        CustomerCreationModel customerModel = new CustomerCreationModel();
        customerModel.setName(customerEntity.getName());
        customerModel.setBonus(customerEntity.getBonus());
        customerModel.setPhoneNumber(customerEntity.getPhoneNumber());
        customerModel.setAddressModel(customerModel.getAddressModel());
        customerModel.setOrders(customerEntityConverter.convert(customerEntity.getOrders(), customerEntity));
        return customerModel;
    }

    public List<OrderCreationModel> convert(List<OrderCreationEntity> orderEntities, CustomerCreationEntity customerEntity) {
        if (orderEntities == null) {
            return new ArrayList<>();
        }
        List<OrderCreationModel> orderModels = customerEntity.getOrders()
                .stream().map(o -> orderEntityConverter.convert(o)).collect(Collectors.toList());
        return orderModels;
    }


    public CustomerUpdateModel convert(CustomerUpdateEntity customerEntity) {
        if (customerEntity == null) {
            return null;
        }
        CustomerUpdateModel customerModel = new CustomerUpdateModel();
        customerModel.setId(customerEntity.getId());
        customerModel.setName(customerEntity.getName());
        customerModel.setBonus(customerEntity.getBonus());
        customerModel.setPhoneNumber(customerEntity.getPhoneNumber());
        AddressUpdateModel addressUpdateModel = addressEntityConverter.convert(customerEntity.getAddress());
        customerModel.setAddressModel(addressUpdateModel);
        customerModel.setOrders(customerEntityConverter.convert(customerEntity.getOrders(), customerEntity));
        return customerModel;
    }

    public List<OrderUpdateModel> convert(List<OrderUpdateEntity> orderEntities, CustomerUpdateEntity customerEntity) {
        if (orderEntities == null) {
            return new ArrayList<>();
        }
        List<OrderUpdateModel> orderModels = customerEntity.getOrders()
                .stream().map(o -> orderEntityConverter.convert(o)).collect(Collectors.toList());
        return orderModels;
    }

}
