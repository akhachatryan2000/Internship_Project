package com.margin.service.shop.validator;


import com.margin.common.exception.response.ExceptionCode;
import com.margin.common.exception.shop.ShopNotValidException;
import com.margin.service.shop.model.ShopModel;
import org.springframework.stereotype.Component;


@Component
public class ShopHasNameValidator {

    public void shopHasName(String name) {
        if (name == null) {
            throw new ShopNotValidException("Shop's name is mandatory", ExceptionCode.UUTI_45);
        }

    }
}
