package com.margin.controller.customer.converter;

import com.margin.controller.customer.dto.CustomerCreationDTO;
import com.margin.controller.customer.dto.CustomerDTO;
import com.margin.controller.customer.dto.CustomerUpdateDTO;
import com.margin.controller.order.converter.OrderDTOConverter;
import com.margin.controller.order.dto.OrderCreationDTO;
import com.margin.controller.order.dto.OrderDTO;
import com.margin.controller.order.dto.OrderUpdateDTO;
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
        if (customerDTO == null) {
            return null;
        }
        CustomerModel customerModel = new CustomerModel(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getPhoneNumber(),
                customerDTO.getAddressId(),
                customerDTO.getBonus()
        );

        return customerModel;
    }


    public CustomerCreationModel convert(CustomerCreationDTO customerDTO) {
        if (customerDTO == null) {
            return null;
        }
        CustomerCreationModel customerModel = new CustomerCreationModel(
                customerDTO.getName(),
                customerDTO.getPhoneNumber(),
                customerDTO.getAddressId(),
                customerDTO.getBonus()
        );

        return customerModel;
    }

    public CustomerUpdateModel convert(CustomerUpdateDTO customerDTO) {
        if (customerDTO == null) {
            return null;
        }
        CustomerUpdateModel customerUpdateModel = new CustomerUpdateModel(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getPhoneNumber(),
                customerDTO.getAddressId(),
                customerDTO.getBonus()
        );
        return customerUpdateModel;
    }

}
