package com.margin.service.customer.validator;

import com.margin.common.exception.customer.CustomerNotValidException;
import com.margin.common.exception.response.ExceptionCode;
import com.margin.service.customer.model.CustomerCreationModel;
import com.margin.service.customer.model.CustomerUpdateModel;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CustomerValidator {

    public void customerIsValid(CustomerCreationModel customerModel) {
        customerHasName(customerModel.getName());
        hasPhoneNumber(customerModel.getPhoneNumber());
        customerHasBonus(customerModel.getBonus());
    }

    public void customerIsValid(CustomerUpdateModel customerModel) {
        customerHasName(customerModel.getName());
        hasPhoneNumber(customerModel.getPhoneNumber());
        customerHasBonus(customerModel.getBonus());
    }

    private void customerHasBonus(BigDecimal bonus) {
        if (bonus == null) {
            throw new CustomerNotValidException("You should provide bonus field", ExceptionCode.UUTI_45);
        }
    }

    private void customerHasName(String name) {
        if (name == null) {
            throw new CustomerNotValidException("Customer's name is mandatory", ExceptionCode.UUTI_45);
        }
    }

    private void hasPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            throw new CustomerNotValidException("Phone number is mandatory", ExceptionCode.UUTI_45);
        }
    }
}
