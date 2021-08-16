package com.margin.controller.customer.converter;

import com.margin.controller.customer.dto.CustomerCreationDTO;
import com.margin.controller.customer.dto.CustomerDTO;
import com.margin.controller.customer.dto.CustomerUpdateDTO;
import com.margin.controller.order.converter.OrderDTOConverter;
import com.margin.controller.order.dto.OrderCreationDTO;
import com.margin.controller.order.dto.OrderDTO;
import com.margin.controller.order.dto.OrderUpdateDTO;
import com.margin.service.customer.converter.CustomerModelConverter;
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
public class CustomerDTOConverter {
    @Autowired
    private OrderDTOConverter orderDTOConverter;
    @Autowired
    private CustomerDTOConverter customerDTOConverter;


    public CustomerModel convert(CustomerDTO customerDTO) {
        if (customerDTO==null) {
            return null;
        }
        CustomerModel customerModel = new CustomerModel();
        customerModel.setId(customerDTO.getId());
        customerModel.setName(customerDTO.getName());
        customerModel.setBonus(customerDTO.getBonus());
        customerModel.setPhoneNumber(customerDTO.getPhoneNumber());
        customerModel.setAddressModel(customerModel.getAddressModel());
        customerModel.setOrders(customerDTOConverter.convert(customerDTO.getOrders(), customerDTO));
        return customerModel;
    }

    public List<OrderModel> convert(List<OrderDTO> orderDTOs, CustomerDTO customerDTO) {
        if (orderDTOs == null) {
            return new ArrayList<OrderModel>();
        }
        List<OrderModel> orderModels = customerDTO.getOrders()
                .stream().map(o -> orderDTOConverter.convert(o))
                .collect(Collectors.toList());
        return orderModels;
    }

    public CustomerCreationModel convert(CustomerCreationDTO customerDTO) {
        if (customerDTO == null) {
            return null;
        }
        CustomerCreationModel customerModel = new CustomerCreationModel();
        customerModel.setName(customerDTO.getName());
        customerModel.setPhoneNumber(customerDTO.getPhoneNumber());
        customerModel.setAddressModel(customerModel.getAddressModel());
        customerModel.setBonus(customerDTO.getBonus());
        customerModel.setOrders(customerDTOConverter.convert(customerDTO.getOrders(), customerDTO));
        return customerModel;
    }

    public List<OrderCreationModel> convert(List<OrderCreationDTO> orderDTOs, CustomerCreationDTO customerDTO) {
        if (orderDTOs == null) {
            return new ArrayList<OrderCreationModel>();
        }
        List<OrderCreationModel> orderCreationModels = customerDTO.getOrders().stream()
                .map(o -> orderDTOConverter.convert(o)).collect(Collectors.toList());
        return orderCreationModels;
    }

    public CustomerUpdateModel convert(CustomerUpdateDTO customerDTO) {
        if(customerDTO==null) {
            return null;
        }
        CustomerUpdateModel customerUpdateModel = new CustomerUpdateModel();
        customerUpdateModel.setId(customerDTO.getId());
        customerUpdateModel.setAddressModel(customerUpdateModel.getAddressModel());
        customerUpdateModel.setName(customerDTO.getName());
        customerUpdateModel.setBonus(customerDTO.getBonus());
        customerUpdateModel.setPhoneNumber(customerDTO.getPhoneNumber());
        customerUpdateModel.setOrders(customerDTOConverter.convert(customerDTO.getOrders(), customerDTO));
        return customerUpdateModel;
    }

    public List<OrderUpdateModel> convert(List<OrderUpdateDTO> orderDTOs, CustomerUpdateDTO customerDTO) {
        if (orderDTOs == null) {
            return new ArrayList<OrderUpdateModel>();
        }
        List<OrderUpdateModel> orderModels = customerDTO.getOrders().stream()
                .map(o -> orderDTOConverter.convert(o)).collect(Collectors.toList());
        return orderModels;
    }
}
