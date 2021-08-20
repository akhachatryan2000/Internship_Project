package com.margin.service.shop;

import com.margin.repository.shop.entity.ShopEntity;
import com.margin.repository.shop.entity.ShopRepository;
import com.margin.service.shop.converter.ShopEntityConverter;
import com.margin.service.shop.model.ShopCreationModel;
import com.margin.service.shop.model.ShopModel;
import com.margin.service.shop.model.ShopUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ShopEntityConverter shopEntityConverter;

    public ShopModel get(Long id) {
        ShopEntity shopEntity = shopRepository.getById(id);
        return shopEntityConverter.convert(shopEntity);
    }

    public ShopModel create(ShopCreationModel shopCreationModel) {
        ShopEntity shopEntity = shopEntityConverter.convert(shopCreationModel);
        ShopEntity shopCreated = shopRepository.save(shopEntity);
        return shopEntityConverter.convert(shopCreated);
    }

    public ShopModel update(ShopUpdateModel shopUpdateModel, Long id) {
        ShopEntity shopEntity = shopRepository.getById(id);
        ShopEntity shopUpdated = shopEntityConverter.convert(shopUpdateModel, shopEntity);
        return shopEntityConverter.convert(shopUpdated);
    }

    public Boolean delete(Long id) {
        shopRepository.deleteById(id);
        return true;
    }
}
