package com.margin.service.shop.converter;

import com.margin.entity.ShopEntity;
import com.margin.service.shop.model.ShopModel;
import org.springframework.stereotype.Component;

@Component
public class ShopEntityConverter {

    public ShopModel convert(ShopEntity shopEntity) {
        if (shopEntity == null) {
            return null;
        }
        return new ShopModel(
                shopEntity.getId(),
                shopEntity.getName(),
                shopEntity.getActive(),
                shopEntity.getVisible());
    }
}
