package com.margin.controller.shop.converter;

import com.margin.controller.shop.dto.ShopCreationDTO;
import com.margin.controller.shop.dto.ShopDTO;
import com.margin.controller.shop.dto.ShopUpdateDTO;
import com.margin.service.shop.model.ShopCreationModel;
import com.margin.service.shop.model.ShopModel;
import com.margin.service.shop.model.ShopUpdateModel;
import org.springframework.stereotype.Component;

@Component
public class ShopDTOConverter {

    public ShopModel convert(ShopDTO shopDTO) {
        if (shopDTO == null) {
            return null;
        }
        return new ShopModel(
                shopDTO.getId(),
                shopDTO.getName(),
                shopDTO.getActive(),
                shopDTO.getVisible());
    }

    public ShopCreationModel convert(ShopCreationDTO shopDTO) {
        if (shopDTO == null) {
            return null;
        }
        return new ShopCreationModel(
                shopDTO.getName(),
                shopDTO.getActive(),
                shopDTO.getVisible());
    }

    public ShopUpdateModel convert(ShopUpdateDTO shopDTO) {
        if (shopDTO == null) {
            return null;
        }
        return new ShopUpdateModel(
                shopDTO.getId(),
                shopDTO.getName(),
                shopDTO.getActive(),
                shopDTO.getVisible());
    }
}
