package com.margin.service.customer.validator;

import com.margin.service.customer.model.CustomerCreationModel;
import com.margin.service.customer.model.CustomerUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerValidator {

    @Autowired
    private CustomerHasNameValidator customerHasNameValidator;

    @Autowired
    private CustomerHasPhoneNumber customerHasPhoneNumber;

    @Autowired
    private CustomerHasBonusValidator bonusValidator;

    public void customerIsValid(CustomerCreationModel customerModel) {
        customerHasNameValidator.customerHasName(customerModel.getName());
        customerHasPhoneNumber.hasPhoneNumber(customerModel.getPhoneNumber());
        bonusValidator.customerHasBonus(customerModel.getBonus());
    }

    public void customerIsValid(CustomerUpdateModel customerModel) {
        customerHasNameValidator.customerHasName(customerModel.getName());
        customerHasPhoneNumber.hasPhoneNumber(customerModel.getPhoneNumber());
        bonusValidator.customerHasBonus(customerModel.getBonus());
    }
}
