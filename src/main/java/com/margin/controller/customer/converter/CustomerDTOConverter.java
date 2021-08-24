package com.margin.controller.customer.converter;

import com.margin.controller.customer.dto.CustomerCreationDTO;
import com.margin.controller.customer.dto.CustomerDTO;
import com.margin.controller.customer.dto.CustomerUpdateDTO;
import com.margin.service.customer.model.CustomerCreationModel;
import com.margin.service.customer.model.CustomerModel;
import com.margin.service.customer.model.CustomerUpdateModel;
import org.springframework.stereotype.Component;

@Component
public class CustomerDTOConverter {

    public CustomerModel convert(CustomerDTO customerDTO) {
        if (customerDTO == null) {
            return null;
        }
        return new CustomerModel(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getPhoneNumber(),
                customerDTO.getAddressId(),
                customerDTO.getBonus());
    }

    public CustomerCreationModel convert(CustomerCreationDTO customerDTO) {
        if (customerDTO == null) {
            return null;
        }
        return new CustomerCreationModel(
                customerDTO.getName(),
                customerDTO.getPhoneNumber(),
                customerDTO.getAddressId(),
                customerDTO.getBonus());
    }

    public CustomerUpdateModel convert(CustomerUpdateDTO customerDTO) {
        if (customerDTO == null) {
            return null;
        }
        return new CustomerUpdateModel(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getPhoneNumber(),
                customerDTO.getAddressId(),
                customerDTO.getBonus());
    }
}
