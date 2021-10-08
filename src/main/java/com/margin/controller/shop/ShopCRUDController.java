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
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/shops")
@AllArgsConstructor
public class ShopCRUDController {

    private ShopService shopService;

    private ShopModelConverter shopModelConverter;

    private ShopDTOConverter shopDTOConverter;

    @GetMapping(path = "/{id}")
    public GenericResponse<ShopDTO> get(@PathVariable(name = "id") Long id) {
        ShopModel shopModel = shopService.get(id);
        ShopDTO shopDTO = shopModelConverter.convert(shopModel);
        return new GenericResponse<>(shopDTO, null);
    }

    @PostMapping("create")
    public GenericResponse<ShopDTO> post(@RequestBody ShopCreationDTO shopCreationDTO) {
        ShopCreationModel shopCreationModel = shopDTOConverter.convert(shopCreationDTO);
        ShopModel shopModel = shopService.create(shopCreationModel);
        ShopDTO shopDTO = shopModelConverter.convert(shopModel);
        return new GenericResponse<>(shopDTO, null);
    }

    @PutMapping("/{id}/update")
    public GenericResponse<ShopDTO> put(@PathVariable(name = "id") Long id, @Valid @RequestBody ShopUpdateDTO shopUpdateDTO) {
        ShopUpdateModel shopUpdateModel = shopDTOConverter.convert(shopUpdateDTO);
        ShopModel shopModel = shopService.update(shopUpdateModel, id);
        ShopDTO shopDTO = shopModelConverter.convert(shopModel);
        return new GenericResponse<>(shopDTO, null);
    }

    @DeleteMapping("/{id}/delete")
    public GenericResponse<Boolean> delete(@PathVariable("id") Long id) {
        Boolean isDeleted = shopService.delete(id);
        return new GenericResponse<>(isDeleted, null);
    }

    @GetMapping
    public GenericResponse<List<ShopDTO>> getAll() {
        List<ShopModel> shopModels = shopService.getAll();
        List<ShopDTO> shopDTOS = shopModels
                .stream()
                .map(shopModel -> shopModelConverter.convert(shopModel))
                .collect(Collectors.toList());
        return new GenericResponse<>(shopDTOS, null);
    }
}
