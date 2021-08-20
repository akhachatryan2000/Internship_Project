package com.margin.controller.orderproduct;

import com.margin.common.GenericResponseDTO;
import com.margin.controller.orderproduct.converter.OrderProductDTOConverter;
import com.margin.controller.orderproduct.dto.OrderProductCreationDTO;
import com.margin.controller.orderproduct.dto.OrderProductDTO;
import com.margin.controller.orderproduct.dto.OrderProductUpdateDTO;
import com.margin.service.orderproduct.OrderProductService;
import com.margin.service.orderproduct.converter.OrderProductModelConverter;
import com.margin.service.orderproduct.model.OrderProductCreationModel;
import com.margin.service.orderproduct.model.OrderProductModel;
import com.margin.service.orderproduct.model.OrderProductUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/order_products")
public class OrderProductCRUDController {

    @Autowired
    private OrderProductService orderProductService;

    @Autowired
    private OrderProductModelConverter orderProductModelConverter;

    @Autowired
    private OrderProductDTOConverter orderProductDTOConverter;

    @GetMapping(path = "/{id}")
    @ResponseBody
    public GenericResponseDTO<OrderProductModel> get(@PathVariable(name = "id") Long id) {
        OrderProductModel orderProductModel = orderProductService.get(id);
        OrderProductDTO orderProductDTO = orderProductModelConverter.convert(orderProductModel);
        // TODO: 18.08.21
        return null;
    }

    @PostMapping
    public GenericResponseDTO<OrderProductModel> post(@RequestBody OrderProductCreationDTO orderProductCreationDTO) {
        OrderProductCreationModel orderProductCreationModel = orderProductDTOConverter.convert(orderProductCreationDTO);
        OrderProductModel orderProductModel = orderProductService.create(orderProductCreationModel);
        OrderProductDTO orderProductDTO = orderProductModelConverter.convert(orderProductModel);
        // TODO: 18.08.21
        return null;
    }

    @PutMapping(path = "/{id}")
    public GenericResponseDTO<OrderProductModel> put(@PathVariable(name = "id") Long id, @RequestBody OrderProductUpdateDTO orderProductUpdateDTO) {
        OrderProductUpdateModel orderProductUpdateModel = orderProductDTOConverter.convert(orderProductUpdateDTO);
        OrderProductModel orderProductModel = orderProductService.update(orderProductUpdateModel, id);
        OrderProductDTO orderProductDTO = orderProductModelConverter.convert(orderProductModel);
        // TODO: 18.08.21
        return null;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(name = "id") Long id) {
        Boolean isDeleted = orderProductService.delete(id);
        return null;
        // TODO: 18.08.21
    }
}
