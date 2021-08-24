package com.margin.controller.order;

import com.margin.common.GenericResponseDTO;
import com.margin.controller.order.converter.OrderDTOConverter;
import com.margin.controller.order.dto.OrderCreationDTO;
import com.margin.controller.order.dto.OrderDTO;
import com.margin.controller.order.dto.OrderUpdateDTO;
import com.margin.service.facade.OrderFacade;
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

    @Autowired
    private OrderFacade orderFacade;


    @GetMapping("/{id}")
    @ResponseBody
    public GenericResponseDTO<OrderDTO> get(@PathVariable(name = "id") Long id) {
        OrderModel orderModel = orderService.get(id);
        OrderDTO orderDTO = orderModelConverter.convert(orderModel);
        return new GenericResponseDTO<>(orderDTO, null);
    }

    @PostMapping
    public GenericResponseDTO<OrderDTO> post(@RequestBody OrderCreationDTO orderCreationDTO) {
        OrderCreationModel orderCreationModel = orderDTOConverter.convert(orderCreationDTO);
        OrderModel orderModel = orderFacade.createOrder(orderCreationModel);
        OrderDTO orderDTO = orderModelConverter.convert(orderModel);
        return new GenericResponseDTO<>(orderDTO, null);
    }

    @PutMapping(name = "/{id}")
    public GenericResponseDTO<OrderDTO> put(@PathVariable(name = "id") Long id, @RequestBody OrderUpdateDTO orderUpdateDTO) {
        OrderUpdateModel orderUpdateModel = orderDTOConverter.convert(orderUpdateDTO);
        OrderModel orderModel = orderService.update(orderUpdateModel, id);
        OrderDTO orderDTO = orderModelConverter.convert(orderModel);
        return new GenericResponseDTO<>(orderDTO, null);
    }

    @DeleteMapping(name = "/{id}")
    public GenericResponseDTO<Boolean> delete(@PathVariable(name = "id") Long id) {
        Boolean isDeleted = orderService.delete(id);
        return new GenericResponseDTO<>(isDeleted, null);
    }
}
