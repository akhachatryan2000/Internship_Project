package com.margin.service.shop.converter;

import com.margin.repository.shop.entity.ShopEntity;
import com.margin.service.shop.model.ShopCreationModel;
import com.margin.service.shop.model.ShopModel;
import com.margin.service.shop.model.ShopUpdateModel;
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
        if (shopUpdateModel == null) {
            return null;
        }
        shopEntity.setVisible(shopUpdateModel.getVisible());
        shopEntity.setActive(shopUpdateModel.getActive());
        shopEntity.setName(shopUpdateModel.getName());
        return shopEntity;
    }
}
