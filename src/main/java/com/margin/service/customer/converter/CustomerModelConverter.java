package com.margin.service.customer.converter;

import com.margin.controller.address.dto.AddressCreationDTO;
import com.margin.controller.address.dto.AddressDTO;
import com.margin.controller.address.dto.AddressUpdateDTO;
import com.margin.controller.customer.dto.CustomerCreationDTO;
import com.margin.controller.customer.dto.CustomerDTO;
import com.margin.controller.customer.dto.CustomerUpdateDTO;
import com.margin.controller.order.dto.OrderCreationDTO;
import com.margin.controller.order.dto.OrderDTO;
import com.margin.controller.order.dto.OrderUpdateDTO;
import com.margin.service.address.converter.AddressModelConverter;
import com.margin.service.address.model.AddressCreationModel;
import com.margin.service.address.model.AddressModel;
import com.margin.service.address.model.AddressUpdateModel;
import com.margin.service.customer.model.CustomerCreationModel;
import com.margin.service.customer.model.CustomerModel;
import com.margin.service.customer.model.CustomerUpdateModel;
import com.margin.service.order.converter.OrderModelConverter;
import com.margin.service.order.model.OrderCreationModel;
import com.margin.service.order.model.OrderModel;
import com.margin.service.order.model.OrderUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerModelConverter {
    @Autowired
    private OrderModelConverter orderModelConverter;

    @Autowired
    private AddressModelConverter addressModelConverter;
    @Autowired
    private CustomerModelConverter customerModelConverter;

    public CustomerDTO convert(CustomerModel customerModel) {
        if (customerModel == null) {
            return null;
        }
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customerModel.getId());
        customerDTO.setName(customerModel.getName());
        customerDTO.setBonus(customerModel.getBonus());
        customerDTO.setPhoneNumber(customerModel.getPhoneNumber());
        AddressModel addressModel = customerModel.getAddressModel();
        AddressDTO addressDTO = addressModelConverter.convert(addressModel);
        customerDTO.setAddress(addressDTO);
        customerDTO.setOrders(customerModelConverter.convert(customerModel.getOrders(), customerModel));
        return customerDTO;

    }

    public List<OrderDTO> convert(List<OrderModel> orderModels, CustomerModel customerModel) {
        if (orderModels == null) {
            return new ArrayList<>();
        }
        List<OrderDTO> orderDTOS = customerModel.getOrders().stream()
                .map(o -> orderModelConverter.convert(o)).collect(Collectors.toList());
        return orderDTOS;
    }

    public CustomerCreationDTO convert(CustomerCreationModel customerModel) {
        if (customerModel == null) {
            return null;
        }
        CustomerCreationDTO customerDTO = new CustomerCreationDTO();
        customerDTO.setName(customerModel.getName());
        customerDTO.setBonus(customerModel.getBonus());
        customerDTO.setPhoneNumber(customerModel.getPhoneNumber());
        AddressCreationModel addressModel = customerModel.getAddressModel();
        AddressCreationDTO addressDTO = addressModelConverter.convert(addressModel);
        customerDTO.setAddress(addressDTO);
        customerDTO.setOrders(customerModelConverter.convert(customerModel.getOrders(), customerModel));
        return customerDTO;


    }

    public List<OrderCreationDTO> convert(List<OrderCreationModel> orderModels, CustomerCreationModel customerModel) {
        if (orderModels == null) {
            return new ArrayList<>();
        }
        List<OrderCreationDTO> orderDTOS = customerModel.getOrders().stream()
                .map(o -> orderModelConverter.convert(o)).collect(Collectors.toList());
        return orderDTOS;
    }


    public CustomerUpdateDTO convert(CustomerUpdateModel customerModel) {
        if (customerModel == null) {
            return null;
        }
        CustomerUpdateDTO customerDTO = new CustomerUpdateDTO();
        customerDTO.setId(customerModel.getId());
        customerDTO.setName(customerModel.getName());
        customerDTO.setBonus(customerModel.getBonus());
        customerDTO.setPhoneNumber(customerModel.getPhoneNumber());
        AddressUpdateModel addressUpdateModel = customerModel.getAddressModel();
        AddressUpdateDTO addressUpdateDTO = addressModelConverter.convert(addressUpdateModel);
        customerDTO.setAddress(addressUpdateDTO);
        customerDTO.setOrders(customerModelConverter.convert(customerModel.getOrders(), customerModel));
        return customerDTO;


    }

    public List<OrderUpdateDTO> convert(List<OrderUpdateModel> orderModels, CustomerUpdateModel customerModel) {
        if (orderModels == null) {
            return new ArrayList<>();
        }
        List<OrderUpdateDTO> orderDTOS = customerModel.getOrders().stream()
                .map(orderUpdateModel -> orderModelConverter.convert(orderUpdateModel)).collect(Collectors.toList());
        return orderDTOS;
    }


}
