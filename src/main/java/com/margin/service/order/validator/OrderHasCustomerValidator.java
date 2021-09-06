package com.margin.service.order.validator;

import com.margin.common.exception.customer.CustomerNotValidException;
import com.margin.common.exception.order.OrderNotValidException;
import com.margin.common.exception.response.ExceptionCode;
import com.margin.repository.customer.CustomerRepository;
import com.margin.repository.order.OrderRepository;
import com.margin.service.customer.validator.CustomerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
public class OrderHasCustomerValidator {

    @Autowired
    private CustomerRepository customerRepository;

    public void orderHasCustomer(Long id) {
        if (id == null) {
            throw new OrderNotValidException("Customer's name is mandatory", ExceptionCode.UUTI_45);
        }
        if (customerRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Customer with this id does not exist");
        }
    }
}
