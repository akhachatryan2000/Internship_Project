package com.margin.controller.order;

import com.margin.common.GenericResponseDTO;
import com.margin.controller.order.converter.OrderDTOConverter;
import com.margin.controller.order.dto.OrderCreationDTO;
import com.margin.controller.order.dto.OrderDTO;
import com.margin.controller.order.dto.OrderUpdateDTO;
import com.margin.service.order.OrderService;
import com.margin.service.order.converter.OrderModelConverter;
import com.margin.service.order.model.OrderCreationModel;
import com.margin.service.order.model.OrderModel;
import com.margin.service.order.model.OrderUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = {"/orders"})
public class OrderCRUDController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderModelConverter orderModelConverter;


    @Autowired
    private OrderDTOConverter orderDTOConverter;


    @GetMapping("/{id}")
    @ResponseBody
    public GenericResponseDTO<OrderDTO> get(@PathVariable(name = "id") Long id) {
        OrderModel orderModel = orderService.get(id);
        OrderDTO orderDTO = orderModelConverter.convert(orderModel);
        // TODO: 18.08.21 Genereic response creation here
        return null;
    }

    @PostMapping
    public GenericResponseDTO<OrderDTO> post(@RequestBody OrderCreationDTO orderCreationDTO) {
        OrderCreationModel orderCreationModel = orderDTOConverter.convert(orderCreationDTO);
        OrderModel orderModel = orderService.create(orderCreationModel);
        OrderDTO orderDTO = orderModelConverter.convert(orderModel);
        // TODO: 18.08.21 Genereic response creation here
        return null;
    }


    @PutMapping(name = "/{id}")
    public GenericResponseDTO<OrderDTO> put(@PathVariable(name = "id") Long id, @RequestBody OrderUpdateDTO orderUpdateDTO) {
        OrderUpdateModel orderUpdateModel = orderDTOConverter.convert(orderUpdateDTO);
        OrderModel orderModel = orderService.update(orderUpdateModel, id);
        OrderDTO orderDTO = orderModelConverter.convert(orderModel);
        // TODO: 18.08.21 Genereic response creation here
        return null;

    }

    @DeleteMapping(name = "/{id}")
    public GenericResponseDTO<Boolean> delete(@PathVariable(name = "id") Long id) {
        Boolean isDeleted = orderService.delete(id);
        // TODO: 18.08.21 Genereic response creation here
        return null;
    }
}
