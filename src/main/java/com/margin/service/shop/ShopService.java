package com.margin.service.shop;

import com.margin.repository.shop.entity.ShopEntity;
import com.margin.repository.shop.entity.ShopRepository;
import com.margin.service.shop.converter.ShopEntityConverter;
import com.margin.service.shop.model.ShopCreationModel;
import com.margin.service.shop.model.ShopModel;
import com.margin.service.shop.model.ShopUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ShopEntityConverter shopEntityConverter;

    public ShopModel get(Long id) {
        ShopEntity shopEntity = shopRepository.getById(id);
        ShopModel shopModel = shopEntityConverter.convert(shopEntity);
        return shopModel;
    }

    public ShopModel create(ShopCreationModel shopCreationModel) {
        ShopEntity shopEntity = shopEntityConverter.convert(shopCreationModel);
        ShopEntity shopCreated = shopRepository.save(shopEntity);
        ShopModel shopModel = shopEntityConverter.convert(shopCreated);
        return shopModel;
    }

    public ShopModel update(ShopUpdateModel shopUpdateModel, Long id) {
        ShopEntity shopEntity = shopRepository.getById(id);
        ShopEntity shopUpdated = shopEntityConverter.convert(shopUpdateModel, shopEntity);
        ShopModel shopModel = shopEntityConverter.convert(shopUpdated);
        return shopModel;
    }

    public Boolean delete(Long id) {
        try {
            shopRepository.deleteById(id);
            return true;
        } catch (EntityNotFoundException exception) {
            System.out.println("No such entity to delete");
        }
        return null;
    }
}
