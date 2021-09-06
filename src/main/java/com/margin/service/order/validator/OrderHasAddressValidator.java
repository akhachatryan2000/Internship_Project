package com.margin.service.order.validator;

import com.margin.common.exception.order.OrderNotValidException;
import com.margin.common.exception.response.ExceptionCode;
import com.margin.repository.address.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
public class OrderHasAddressValidator {

    @Autowired
    private AddressRepository addressRepository;

    public void hasAddress(Long id) {
        if (id == null) {
            throw new OrderNotValidException("Order address is mandatory", ExceptionCode.UUTI_45);
        }
        if (addressRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Address with this id does not exist");
        }

    }
}
