package com.margin.service.orderproduct.validator;

import com.margin.common.exception.orderproduct.OrderProductNotValidException;
import com.margin.common.exception.response.ExceptionCode;
import com.margin.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
public class OrderProductHasProductIdValidator {

    @Autowired
    private ProductRepository productRepository;

    public void orderProductHasProductId(Long id) {
        if (id == null) {
            throw new OrderProductNotValidException("Order product must have product id", ExceptionCode.UUTI_45);
        }
        if (productRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Product with this id does not exist");
        }
    }
}
