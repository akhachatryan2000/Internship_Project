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

    public CustomerDTO convert(CustomerModel customerModel) {
        if (customerModel == null) {
            return null;
        }
        CustomerDTO customerDTO = new CustomerDTO(customerModel.getId(),
                customerModel.getName(),
                customerModel.getPhoneNumber(),
                customerModel.getAddressId(),
                customerModel.getBonus(),
                customerModel.getOrders());
//        customerDTO.setId(customerModel.getId());
//        customerDTO.setName(customerModel.getName());
//        customerDTO.setBonus(customerModel.getBonus());
//        customerDTO.setPhoneNumber(customerModel.getPhoneNumber());
//        customerDTO.setAddressId(customerModel.getAddressId());
//        customerDTO.setOrderIds(customerModel.getOrderIds());
        return customerDTO;

    }

//    public List<OrderDTO> convert(List<OrderModel> orderModels, CustomerModel customerModel) {
//        if (orderModels == null) {
//            return new ArrayList<>();
//        }
//        List<OrderDTO> orderDTOS = customerModel.getOrders().stream()
//                .map(o -> orderModelConverter.convert(o)).collect(Collectors.toList());
//        return orderDTOS;
//    }

    public CustomerCreationDTO convert(CustomerCreationModel customerModel) {
        if (customerModel == null) {
            return null;
        }
        CustomerCreationDTO customerDTO = new CustomerCreationDTO(
                customerModel.getName(),
                customerModel.getPhoneNumber(),
                customerModel.getAddressId(),
                customerModel.getBonus(),
                customerModel.getOrders());
        return customerDTO;
    }

//    public List<OrderCreationDTO> convert(List<OrderCreationModel> orderModels, CustomerCreationModel customerModel) {
//        if (orderModels == null) {
//            return new ArrayList<>();
//        }
//        List<OrderCreationDTO> orderDTOS = customerModel.getOrders().stream()
//                .map(o -> orderModelConverter.convert(o)).collect(Collectors.toList());
//        return orderDTOS;
//    }


    public CustomerUpdateDTO convert(CustomerUpdateModel customerModel) {
        if (customerModel == null) {
            return null;
        }
        CustomerUpdateDTO customerDTO = new CustomerUpdateDTO(
                customerModel.getId(),
                customerModel.getName(),
                customerModel.getPhoneNumber(),
                customerModel.getAddressId(),
                customerModel.getBonus(),
                customerModel.getOrders());
        return customerDTO;


    }

//    public List<OrderUpdateDTO> convert(List<OrderUpdateModel> orderModels, CustomerUpdateModel customerModel) {
//        if (orderModels == null) {
//            return new ArrayList<>();
//        }
//        List<OrderUpdateDTO> orderDTOS = customerModel.getOrders().stream()
//                .map(orderUpdateModel -> orderModelConverter.convert(orderUpdateModel)).collect(Collectors.toList());
//        return orderDTOS;
//    }


}
