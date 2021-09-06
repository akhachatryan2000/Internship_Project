package com.margin.service.order.validator;

import com.margin.common.exception.order.OrderNotValidException;
import com.margin.common.exception.response.ExceptionCode;
import com.margin.repository.shop.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
public class OrderHasShopValidator {

    @Autowired
    private ShopRepository shopRepository;

    public void hasShop(Long id) {
        if (id == null) {
            throw new OrderNotValidException("Shop id is mandatory", ExceptionCode.UUTI_45);
        }
        if (!shopRepository.findById(id).isPresent()) {
            throw new EntityNotFoundException("Shop with such id does not exist");
        }

    }
}
