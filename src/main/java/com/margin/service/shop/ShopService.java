package com.margin.service.shop;

import com.margin.entity.ShopEntity;
import com.margin.repository.shop.ShopRepository;
import com.margin.service.shop.converter.ShopEntityConverter;
import com.margin.service.shop.converter.ShopModelConverter;
import com.margin.service.shop.model.ShopCreationModel;
import com.margin.service.shop.model.ShopModel;
import com.margin.service.shop.model.ShopUpdateModel;
import com.margin.service.shop.validator.ShopValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class ShopService {

    private ShopRepository shopRepository;

    private ShopEntityConverter shopEntityConverter;

    private ShopModelConverter shopModelConverter;

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
        ShopEntity shopEntity = shopRepository.findByIdAndDeletedIsFalse(id)
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

    public List<ShopModel> getAll() {
        List<ShopEntity> shopEntities = shopRepository.findAllOrdered();
        return shopEntities
                .stream()
                .map(shopEntity -> shopEntityConverter.convert(shopEntity))
                .collect(Collectors.toList());
    }
}
