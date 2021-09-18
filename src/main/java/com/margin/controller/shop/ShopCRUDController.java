package com.margin.controller.shop;

import com.margin.common.exception.response.GenericResponse;
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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/shops")
@PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
public class ShopCRUDController {

    @Autowired
    private ShopService shopService;

    @Autowired
    private ShopModelConverter shopModelConverter;

    @Autowired
    private ShopDTOConverter shopDTOConverter;

    @GetMapping(path = "/{id}")
    @ResponseBody
    public GenericResponse<ShopDTO> get(@PathVariable(name = "id") Long id) {
        ShopModel shopModel = shopService.get(id);
        ShopDTO shopDTO = shopModelConverter.convert(shopModel);
        return new GenericResponse<>(shopDTO, null);
    }

    @PostMapping
    public GenericResponse<ShopDTO> post(@Valid @RequestBody ShopCreationDTO shopCreationDTO) {
        ShopCreationModel shopCreationModel = shopDTOConverter.convert(shopCreationDTO);
        ShopModel shopModel = shopService.create(shopCreationModel);
        ShopDTO shopDTO = shopModelConverter.convert(shopModel);
        return new GenericResponse<>(shopDTO, null);
    }

    @PutMapping("/{id}")
    public GenericResponse<ShopDTO> put(@PathVariable(name = "id") Long id, @Valid @RequestBody ShopUpdateDTO shopUpdateDTO) {
        ShopUpdateModel shopUpdateModel = shopDTOConverter.convert(shopUpdateDTO);
        ShopModel shopModel = shopService.update(shopUpdateModel, id);
        ShopDTO shopDTO = shopModelConverter.convert(shopModel);
        return new GenericResponse<>(shopDTO, null);
    }

    @DeleteMapping("/{id}")
    public GenericResponse<Boolean> delete(@PathVariable("id") Long id) {
        Boolean isDeleted = shopService.delete(id);
        return new GenericResponse<>(isDeleted, null);
    }
}
