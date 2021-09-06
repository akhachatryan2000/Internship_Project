package com.margin.service.shop.validator;

import com.margin.common.exception.response.ExceptionCode;
import com.margin.common.exception.shop.ShopNotValidException;
import com.margin.repository.shop.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShopIsUniqueValidator {

    @Autowired
    private ShopRepository shopRepository;

    public void shopIsUnique(String name) {
        if (shopRepository.findByName(name).isPresent())
            throw new ShopNotValidException("Shop already exists", ExceptionCode.UUTI_45);
    }
}


