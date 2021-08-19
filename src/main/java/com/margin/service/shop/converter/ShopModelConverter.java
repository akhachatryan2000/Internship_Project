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
        ShopDTO shopDTO = new ShopDTO(
                shopModel.getId(),
                shopModel.getName(),
                shopModel.getActive(),
                shopModel.getVisible());
        return shopDTO;

    }

    public ShopCreationDTO convert(ShopCreationModel shopModel) {
        if (shopModel == null) {
            return null;
        }
        ShopCreationDTO shopDTO = new ShopCreationDTO(
                shopModel.getName(),
                shopModel.getActive(),
                shopModel.getVisible());
        return shopDTO;

    }

    public ShopUpdateDTO convert(ShopUpdateModel shopModel) {
        if (shopModel == null) {
            return null;
        }
        ShopUpdateDTO shopDTO = new ShopUpdateDTO(
                shopModel.getId(),
                shopModel.getName(),
                shopModel.getActive(),
                shopModel.getVisible());
        return shopDTO;

    }

}
