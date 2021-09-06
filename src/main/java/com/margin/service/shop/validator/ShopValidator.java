package com.margin.service.shop.validator;

import com.margin.service.shop.model.ShopModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShopValidator {

    @Autowired
    private ShopHasNameValidator shopHasNameValidator;

    @Autowired
    private ShopIsUniqueValidator shopIsUniqueValidator;

    public void shopIsValid(String name) {
        shopHasNameValidator.shopHasName(name);
        shopIsUniqueValidator.shopIsUnique(name);
    }
}
