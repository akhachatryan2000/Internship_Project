package com.margin.controller.shop;

import com.margin.common.GenericResponseDTO;
import com.margin.controller.shop.converter.ShopDTOConverter;
import com.margin.controller.shop.dto.ShopCreationDTO;
import com.margin.controller.shop.dto.ShopDTO;
import com.margin.controller.shop.dto.ShopUpdateDTO;
import com.margin.service.shop.ShopService;
import com.margin.service.shop.converter.ShopModelConverter;
import com.margin.service.shop.model.ShopCreationModel;
import com.margin.service.shop.model.ShopModel;
import com.margin.service.shop.model.ShopUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/shops")
public class ShopCRUDController {

    @Autowired
    private ShopService shopService;

    @Autowired
    private ShopModelConverter shopModelConverter;

    @Autowired
    private ShopDTOConverter shopDTOConverter;

    @GetMapping(name = "/{id}")
    @ResponseBody
    public GenericResponseDTO<ShopDTO> get(@PathVariable(name = "id") Long id) {
        ShopModel shopModel = shopService.get(id);
        ShopDTO shopDTO = shopModelConverter.convert(shopModel);
        // TODO: 18.08.21 Genereic response creation here
        return null;
    }

    @PostMapping
    public GenericResponseDTO<ShopDTO> post(@RequestBody ShopCreationDTO shopCreationDTO) {
        ShopCreationModel shopCreationModel = shopDTOConverter.convert(shopCreationDTO);
        ShopModel shopModel = shopService.create(shopCreationModel);
        ShopDTO shopDTO = shopModelConverter.convert(shopModel);
        // TODO: 18.08.21 Genereic response creation here
        return null;
    }

    @PutMapping("/{id}")
    public GenericResponseDTO<ShopDTO> put(@PathVariable(name = "id") Long id, ShopUpdateDTO shopUpdateDTO) {
        ShopUpdateModel shopUpdateModel = shopDTOConverter.convert(shopUpdateDTO);
        ShopModel shopModel = shopService.update(shopUpdateModel, id);
        ShopDTO shopDTO = shopModelConverter.convert(shopModel);
        // TODO: 18.08.21 Genereic response creation here
        return null;
    }

    @DeleteMapping("/{id}")
    public GenericResponseDTO<Boolean> delete(@PathVariable("id") Long id) {
        Boolean isDeleted = shopService.delete(id);
        // TODO: 18.08.21 Genereic response creation here
        return null;
    }
}
