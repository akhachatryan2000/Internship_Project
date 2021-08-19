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

    // TODO: 19.08.21 The CustomerDto and model does not have orderLIst

    public CustomerDTO convert(CustomerModel customerModel) {
        if (customerModel == null) {
            return null;
        }
        CustomerDTO customerDTO = new CustomerDTO(
                customerModel.getId(),
                customerModel.getName(),
                customerModel.getPhoneNumber(),
                customerModel.getAddressId(),
                customerModel.getBonus());
        return customerDTO;

    }

    public CustomerCreationDTO convert(CustomerCreationModel customerModel) {
        if (customerModel == null) {
            return null;
        }
        CustomerCreationDTO customerDTO = new CustomerCreationDTO(
                customerModel.getName(),
                customerModel.getPhoneNumber(),
                customerModel.getAddressId(),
                customerModel.getBonus());
        return customerDTO;
    }

    public CustomerUpdateDTO convert(CustomerUpdateModel customerModel) {
        if (customerModel == null) {
            return null;
        }
        CustomerUpdateDTO customerDTO = new CustomerUpdateDTO(
                customerModel.getId(),
                customerModel.getName(),
                customerModel.getPhoneNumber(),
                customerModel.getAddressId(),
                customerModel.getBonus());
        return customerDTO;


    }
}
