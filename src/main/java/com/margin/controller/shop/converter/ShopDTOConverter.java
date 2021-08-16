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
            ShopModel shopModel = new ShopModel();
            shopModel.setId(shopDTO.getId());
            shopModel.setName(shopDTO.getName());
            shopModel.setActive(shopDTO.getActive());
            shopModel.setVisible(shopDTO.getVisible());
            shopModel.setSchedule(shopDTO.getSchedule());
            //shopModel.setUser(shopDTO.getUser());
            return shopModel;
        }

    }

    public ShopCreationModel convert(ShopCreationDTO shopDTO) {
        if (shopDTO==null)  {
            return null;
        }
        ShopCreationModel shopModel = new ShopCreationModel();
        shopModel.setName(shopDTO.getName());
        shopModel.setActive(shopDTO.getActive());
        shopModel.setVisible(shopDTO.getVisible());
        shopModel.setSchedule(shopDTO.getSchedule());
        // shopModel.setUser(shopDTO.getUser());
        return shopModel;
    }

    public ShopUpdateModel convert(ShopUpdateDTO shopDTO) {
        if (shopDTO==null)  {
            return null;
        }
        ShopUpdateModel shopModel = new ShopUpdateModel();
        shopModel.setId(shopDTO.getId());
        shopModel.setName(shopDTO.getName());
        shopModel.setActive(shopDTO.getActive());
        shopModel.setVisible(shopDTO.getVisible());
        shopModel.setSchedule(shopDTO.getSchedule());
        // shopModel.setUser(shopDTO.getUser());
        return shopModel;


    }
}
