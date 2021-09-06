package com.margin.service.shop;

import com.margin.repository.shop.entity.ShopEntity;
import com.margin.repository.shop.ShopRepository;
import com.margin.service.shop.converter.ShopEntityConverter;
import com.margin.service.shop.converter.ShopModelConverter;
import com.margin.service.shop.model.ShopCreationModel;
import com.margin.service.shop.model.ShopModel;
import com.margin.service.shop.model.ShopUpdateModel;
import com.margin.service.shop.validator.ShopValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;


@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ShopEntityConverter shopEntityConverter;

    @Autowired
    private ShopModelConverter shopModelConverter;

    @Autowired
    private ShopValidator shopValidator;

    public ShopModel get(Long id) {
        ShopEntity shopEntity = shopRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Shop with id " + id + " does not exist"));
        return shopEntityConverter.convert(shopEntity);
    }

    @Transactional
    public ShopModel create(ShopCreationModel shopCreationModel) {
        shopValidator.shopIsValid(shopCreationModel.getName());
        ShopEntity shopEntity = shopModelConverter.convert(shopCreationModel);
        shopEntity = shopRepository.save(shopEntity);
        return shopEntityConverter.convert(shopEntity);
    }

    @Transactional
    public ShopModel update(ShopUpdateModel shopUpdateModel, Long id) {
        ShopEntity shopEntity = shopRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Shop with this id does not exist"));
        shopValidator.shopIsValid(shopUpdateModel.getName());
        shopEntity = shopModelConverter.convert(shopUpdateModel, shopEntity);
        shopEntity = shopRepository.save(shopEntity);
        return shopEntityConverter.convert(shopEntity);
    }

    public Boolean delete(Long id) {
        shopRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No such user to delete"));
        shopRepository.updateDeleted(id);
        return true;
    }
}
