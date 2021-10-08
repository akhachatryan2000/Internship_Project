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
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = {"/orders"})
@AllArgsConstructor
public class OrderCRUDController {

    private OrderService orderService;

    private OrderModelConverter orderModelConverter;

    private OrderDTOConverter orderDTOConverter;

    private OrderFacade orderFacade;

    @GetMapping("/{id}")
    public GenericResponse<OrderDTO> get(@PathVariable(name = "id") Long id) {
        OrderModel orderModel = orderService.get(id);
        OrderDTO orderDTO = orderModelConverter.convert(orderModel);
        return new GenericResponse<>(orderDTO, null);
    }

    @PostMapping("/create")
    public GenericResponse<OrderDTO> post(@Valid @RequestBody OrderCreationDTO orderCreationDTO) {
        OrderCreationModel orderCreationModel = orderDTOConverter.convert(orderCreationDTO);
        OrderModel orderModel = orderFacade.createOrder(orderCreationModel);
        OrderDTO orderDTO = orderModelConverter.convert(orderModel);
        return new GenericResponse<>(orderDTO, null);
    }

    @PutMapping(path = "/{id}/update")
    public GenericResponse<OrderDTO> put(@PathVariable(name = "id") Long id, @Valid @RequestBody OrderUpdateDTO orderUpdateDTO) {
        OrderUpdateModel orderUpdateModel = orderDTOConverter.convert(orderUpdateDTO);
        OrderModel orderModel = orderService.update(orderUpdateModel, id);
        OrderDTO orderDTO = orderModelConverter.convert(orderModel);
        return new GenericResponse<>(orderDTO, null);
    }

    @DeleteMapping(path = "/{id}/delete")
    public GenericResponse<Boolean> delete(@PathVariable(name = "id") Long id) {
        Boolean isDeleted = orderService.delete(id);
        return new GenericResponse<>(isDeleted, null);
    }

    @GetMapping
    public GenericResponse<List<OrderDTO>> getAll() {
        List<OrderModel> orderModels = orderService.getAll();
        List<OrderDTO> orders = orderModels
                .stream()
                .map(orderModel -> orderModelConverter.convert(orderModel))
                .collect(Collectors.toList());
        return new GenericResponse<>(orders, null);
    }
}
