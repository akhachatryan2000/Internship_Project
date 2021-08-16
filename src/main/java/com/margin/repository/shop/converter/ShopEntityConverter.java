package com.margin.repository.shop.converter;

import com.margin.repository.shop.entity.ShopCreationEntity;
import com.margin.repository.shop.entity.ShopEntity;
import com.margin.repository.shop.entity.ShopUpdateEntity;
import com.margin.service.shop.model.ShopCreationModel;
import com.margin.service.shop.model.ShopModel;
import com.margin.service.shop.model.ShopUpdateModel;
import org.springframework.stereotype.Component;

@Component
public class ShopEntityConverter {

    public ShopModel convert(ShopEntity shopEntity){
        if (shopEntity==null) {
            return null;
        }
        ShopModel shopModel = new ShopModel();
        shopModel.setId(shopEntity.getId());
        shopModel.setName(shopEntity.getName());
        shopModel.setActive(shopEntity.getActive());
        shopModel.setVisible(shopEntity.getVisible());
       // shopModel.setSchedule(shopEntity.getSchedule());
        // shopModel.setUser(shopEntity.getUser());
        return shopModel;

    }

    public ShopCreationModel convert(ShopCreationEntity shopEntity) {
        if (shopEntity==null) {
            return null;
        }
        ShopCreationModel shopModel= new ShopCreationModel();
        shopModel.setName(shopEntity.getName());
        shopModel.setActive(shopEntity.getActive());
        shopModel.setVisible(shopEntity.getVisible());
        shopModel.setSchedule(shopEntity.getSchedule());
        // shopModel.setUser(shopEntity.getUser());
        return shopModel;

    }

    public ShopUpdateModel convert(ShopUpdateEntity shopEntity) {
        if (shopEntity==null) {
            return null;
        }
        ShopUpdateModel shopModel= new ShopUpdateModel();
        shopModel.setId(shopEntity.getId());
        shopModel.setName(shopEntity.getName());
        shopModel.setActive(shopEntity.getActive());
        shopModel.setVisible(shopEntity.getVisible());
        shopModel.setSchedule(shopEntity.getSchedule());
        // shopModel.setUser(shopEntity.getUser());
        return shopModel;

    }
}
