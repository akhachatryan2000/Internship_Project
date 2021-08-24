package com.margin.service.shop;

import com.margin.repository.shop.entity.ShopEntity;
import com.margin.repository.shop.entity.ShopRepository;
import com.margin.service.shop.converter.ShopEntityConverter;
import com.margin.service.shop.converter.ShopModelConverter;
import com.margin.service.shop.model.ShopCreationModel;
import com.margin.service.shop.model.ShopModel;
import com.margin.service.shop.model.ShopUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ShopEntityConverter shopEntityConverter;

    @Autowired
    private ShopModelConverter shopModelConverter;

    public ShopModel get(Long id) {
        ShopEntity shopEntity = shopRepository.getById(id);
        return shopEntityConverter.convert(shopEntity);
    }

    @Transactional
    public ShopModel create(ShopCreationModel shopCreationModel) {
        ShopEntity shopEntity = shopModelConverter.convert(shopCreationModel);
        shopEntity = shopRepository.save(shopEntity);
        return shopEntityConverter.convert(shopEntity);
    }

    @Transactional
    public ShopModel update(ShopUpdateModel shopUpdateModel, Long id) {
        ShopEntity shopEntity = shopRepository.getById(id);
        shopEntity = shopModelConverter.convert(shopUpdateModel, shopEntity);
        shopEntity = shopRepository.save(shopEntity);
        return shopEntityConverter.convert(shopEntity);
    }

    public Boolean delete(Long id) {
        shopRepository.deleteById(id);
        return true;
    }
}
