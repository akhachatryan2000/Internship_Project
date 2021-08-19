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
        } else {
            ShopModel shopModel = new ShopModel(
                    shopDTO.getId(),
                    shopDTO.getName(),
                    shopDTO.getActive(),
                    shopDTO.getVisible()
            );
            return shopModel;
        }

    }

    public ShopCreationModel convert(ShopCreationDTO shopDTO) {
        if (shopDTO == null) {
            return null;
        }
        ShopCreationModel shopModel = new ShopCreationModel(
                shopDTO.getName(),
                shopDTO.getActive(),
                shopDTO.getVisible()
        );

        return shopModel;
    }

    public ShopUpdateModel convert(ShopUpdateDTO shopDTO) {
        if (shopDTO == null) {
            return null;
        }
        ShopUpdateModel shopModel = new ShopUpdateModel(
                shopDTO.getId(),
                shopDTO.getName(),
                shopDTO.getActive(),
                shopDTO.getVisible()
        );

        return shopModel;


    }
}
