package com.margin.service.orderproduct.validator;

import com.margin.common.exception.orderproduct.OrderProductNotValidException;
import com.margin.common.exception.response.ExceptionCode;
import com.margin.repository.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
public class OrderProductHasOrderIdValidator {

    @Autowired
    private OrderRepository orderRepository;

    public void orderProductHasOrderId(Long id) {
        if (id == null) {
            throw new OrderProductNotValidException("Order product must have order id", ExceptionCode.UUTI_45);
        }
        if (orderRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Such order does not exist");
        }
    }
}
