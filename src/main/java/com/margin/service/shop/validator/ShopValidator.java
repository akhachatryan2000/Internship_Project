package com.margin.service.shop.validator;

import com.margin.common.exception.response.ExceptionCode;
import com.margin.common.exception.shop.ShopNotValidException;
import com.margin.repository.shop.ShopRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ShopValidator {

    private ShopRepository shopRepository;

    public void shopIsValid(String name) {
        shopHasName(name);
        shopIsUnique(name);
    }

    private void shopIsUnique(String name) {
        if (shopRepository.findByName(name).isPresent())
            throw new ShopNotValidException("Shop already exists", ExceptionCode.UUTI_45);
    }

    private void shopHasName(String name) {
        if (name == null || name.isBlank()) {
            throw new ShopNotValidException("Shop's name is mandatory", ExceptionCode.UUTI_45);
        }
    }
}
