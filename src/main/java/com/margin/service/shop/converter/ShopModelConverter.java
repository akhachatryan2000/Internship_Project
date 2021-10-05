package com.margin.service.shop.converter;

import com.margin.controller.shop.dto.ShopDTO;
import com.margin.entity.ShopEntity;
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

    public ShopEntity convert(ShopCreationModel shopCreationModel) {
        if (shopCreationModel == null) {
            return null;
        }
        ShopEntity shopEntity = new ShopEntity();
        shopEntity.setName(shopCreationModel.getName());
        shopEntity.setActive(shopCreationModel.getActive());
        shopEntity.setVisible(shopCreationModel.getVisible());
        return shopEntity;
    }

    public ShopEntity convert(ShopUpdateModel shopUpdateModel, ShopEntity shopEntity) {
        if (shopUpdateModel == null && shopEntity == null) {
            return null;
        }
        shopEntity.setVisible(shopUpdateModel.getVisible());
        shopEntity.setActive(shopUpdateModel.getActive());
        shopEntity.setName(shopUpdateModel.getName());
        return shopEntity;
    }
}
