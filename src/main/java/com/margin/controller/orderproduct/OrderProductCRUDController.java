package com.margin.controller.orderproduct;

import com.margin.common.exception.response.GenericResponse;
import com.margin.controller.orderproduct.converter.OrderProductDTOConverter;
import com.margin.controller.orderproduct.dto.OrderProductCreationDTO;
import com.margin.controller.orderproduct.dto.OrderProductDTO;
import com.margin.controller.orderproduct.dto.OrderProductUpdateDTO;
import com.margin.service.orderproduct.OrderProductService;
import com.margin.service.orderproduct.converter.OrderProductModelConverter;
import com.margin.service.orderproduct.model.OrderProductCreationModel;
import com.margin.service.orderproduct.model.OrderProductModel;
import com.margin.service.orderproduct.model.OrderProductUpdateModel;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order_products")
@AllArgsConstructor
public class OrderProductCRUDController {

    private OrderProductService orderProductService;

    private OrderProductModelConverter orderProductModelConverter;

    private OrderProductDTOConverter orderProductDTOConverter;

    @GetMapping(path = "/{id}")
    public GenericResponse<OrderProductDTO> get(@PathVariable(name = "id") Long id) {
        OrderProductModel orderProductModel = orderProductService.get(id);
        OrderProductDTO orderProductDTO = orderProductModelConverter.convert(orderProductModel);
        return new GenericResponse<>(orderProductDTO, null);
    }

    @PostMapping("create")
    public GenericResponse<OrderProductDTO> post(@RequestBody OrderProductCreationDTO orderProductCreationDTO) {
        OrderProductCreationModel orderProductCreationModel = orderProductDTOConverter.convert(orderProductCreationDTO);
        OrderProductModel orderProductModel = orderProductService.create(orderProductCreationModel);
        OrderProductDTO orderProductDTO = orderProductModelConverter.convert(orderProductModel);
        return new GenericResponse<>(orderProductDTO, null);
    }

    @PutMapping(path = "/{id}/update")
    public GenericResponse<OrderProductDTO> put(@PathVariable(name = "id") Long id, @RequestBody OrderProductUpdateDTO orderProductUpdateDTO) {
        OrderProductUpdateModel orderProductUpdateModel = orderProductDTOConverter.convert(orderProductUpdateDTO);
        OrderProductModel orderProductModel = orderProductService.update(orderProductUpdateModel, id);
        OrderProductDTO orderProductDTO = orderProductModelConverter.convert(orderProductModel);
        return new GenericResponse<>(orderProductDTO, null);
    }

    @DeleteMapping(path = "/{id}/delete")
    public GenericResponse<Boolean> delete(@PathVariable(name = "id") Long id) {
        Boolean isDeleted = orderProductService.delete(id);
        return new GenericResponse<>(isDeleted, null);
    }

    @GetMapping
    public GenericResponse<List<OrderProductDTO>> getAll() {
        List<OrderProductModel> orderProductModels = orderProductService.getAll();
        List<OrderProductDTO> orderProductDTOS = orderProductModels
                .stream()
                .map(orderProductModel -> orderProductModelConverter.convert(orderProductModel))
                .collect(Collectors.toList());
        return new GenericResponse<>(orderProductDTOS, null);
    }
}
