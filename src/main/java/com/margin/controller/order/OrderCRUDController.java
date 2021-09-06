package com.margin.controller.order;

import com.margin.common.exception.response.GenericResponse;
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

import javax.validation.Valid;

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
    public GenericResponse<OrderDTO> get(@PathVariable(name = "id") Long id) {
        OrderModel orderModel = orderService.get(id);
        OrderDTO orderDTO = orderModelConverter.convert(orderModel);
        return new GenericResponse<>(orderDTO, null);
    }

    @PostMapping
    public GenericResponse<OrderDTO> post(@Valid @RequestBody OrderCreationDTO orderCreationDTO) {
        OrderCreationModel orderCreationModel = orderDTOConverter.convert(orderCreationDTO);
        OrderModel orderModel = orderFacade.createOrder(orderCreationModel);
        OrderDTO orderDTO = orderModelConverter.convert(orderModel);
        return new GenericResponse<>(orderDTO, null);
    }

    @PutMapping(path = "/{id}")
    public GenericResponse<OrderDTO> put(@PathVariable(name = "id") Long id, @Valid @RequestBody OrderUpdateDTO orderUpdateDTO) {
        OrderUpdateModel orderUpdateModel = orderDTOConverter.convert(orderUpdateDTO);
        OrderModel orderModel = orderService.update(orderUpdateModel, id);
        OrderDTO orderDTO = orderModelConverter.convert(orderModel);
        return new GenericResponse<>(orderDTO, null);
    }

    @DeleteMapping(path = "/{id}")
    public GenericResponse<Boolean> delete(@PathVariable(name = "id") Long id) {
        Boolean isDeleted = orderService.delete(id);
        return new GenericResponse<>(isDeleted, null);
    }
}
