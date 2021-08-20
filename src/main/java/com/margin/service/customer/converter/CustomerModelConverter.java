package com.margin.service.customer.converter;

import com.margin.controller.customer.dto.CustomerCreationDTO;
import com.margin.controller.customer.dto.CustomerDTO;
import com.margin.controller.customer.dto.CustomerUpdateDTO;
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

    public CustomerCreationDTO convert(CustomerCreationModel customerModel) {
        if (customerModel == null) {
            return null;
        }
        return new CustomerCreationDTO(
                customerModel.getName(),
                customerModel.getPhoneNumber(),
                customerModel.getAddressId(),
                customerModel.getBonus());
    }

    public CustomerUpdateDTO convert(CustomerUpdateModel customerModel) {
        if (customerModel == null) {
            return null;
        }
        return new CustomerUpdateDTO(
                customerModel.getId(),
                customerModel.getName(),
                customerModel.getPhoneNumber(),
                customerModel.getAddressId(),
                customerModel.getBonus());
    }
}
