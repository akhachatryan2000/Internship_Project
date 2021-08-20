package com.margin.service.shop.converter;

import com.margin.controller.shop.dto.ShopCreationDTO;
import com.margin.controller.shop.dto.ShopDTO;
import com.margin.controller.shop.dto.ShopUpdateDTO;
import com.margin.service.shop.model.ShopCreationModel;
import com.margin.service.shop.model.ShopModel;
import com.margin.service.shop.model.ShopUpdateModel;
import org.springframework.stereotype.Component;

@Component
public class ShopModelConverter {

    public ShopDTO convert(ShopModel shopModel) {
        if (shopModel == null) {
            return null;
        }
        return new ShopDTO(
                shopModel.getId(),
                shopModel.getName(),
                shopModel.getActive(),
                shopModel.getVisible());
    }
}
