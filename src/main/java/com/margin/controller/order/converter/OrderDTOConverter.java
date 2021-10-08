package com.margin.controller.order.converter;

import com.margin.controller.order.dto.OrderCreationDTO;
import com.margin.controller.order.dto.OrderDTO;
import com.margin.controller.order.dto.OrderUpdateDTO;
import com.margin.controller.orderproduct.converter.OrderProductDTOConverter;
import com.margin.controller.orderproduct.dto.OrderProductCreationDTO;
import com.margin.controller.orderproduct.dto.OrderProductDTO;
import com.margin.service.order.model.OrderCreationModel;
import com.margin.service.order.model.OrderModel;
import com.margin.service.order.model.OrderUpdateModel;
import com.margin.service.orderproduct.model.OrderProductCreationModel;
import com.margin.service.orderproduct.model.OrderProductModel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class OrderDTOConverter {

    private OrderProductDTOConverter orderProductDTOConverter;

    public OrderModel convert(OrderDTO orderDTO) {
        if (orderDTO == null) {
            return null;
        }

        return new OrderModel(
                orderDTO.getId(),
                convertList(orderDTO.getOrderProducts(), orderDTO),
                orderDTO.getCustomerId(),
                orderDTO.getShopId(),
                orderDTO.getAddressId(),
                orderDTO.getOriginalPrice(),
                orderDTO.getTotalPrice(),
                orderDTO.getPaidFromBonus(),
                orderDTO.getPaymentType(),
                orderDTO.getOrderDiscount());
    }

    public List<OrderProductModel> convertList(List<OrderProductDTO> orderProductDTOS, OrderDTO orderDTO) {
        if (orderProductDTOS == null) {
            return new ArrayList<>();
        }
        return orderDTO.getOrderProducts()
                .stream()
                .map(orderProductDTO -> orderProductDTOConverter
                        .convert(orderProductDTO))
                .collect(Collectors.toList());
    }

    public OrderCreationModel convert(OrderCreationDTO orderDTO) {
        if (orderDTO == null) {
            return null;
        }
        return new OrderCreationModel(
                convertList(orderDTO.getOrderProducts(), orderDTO),
                orderDTO.getCustomerId(),
                orderDTO.getShopId(),
                orderDTO.getAddressId(),
                orderDTO.getOriginalPrice(),
                orderDTO.getTotalPrice(),
                orderDTO.getPaidFromBonus(),
                orderDTO.getPaymentType(),
                orderDTO.getOrderDiscount());
    }

    public List<OrderProductCreationModel> convertList(List<OrderProductCreationDTO> orderProductDTOS, OrderCreationDTO orderDTO) {
        if (orderProductDTOS == null) {
            return new ArrayList<>();
        }
        return orderDTO.getOrderProducts()
                .stream()
                .map(o -> orderProductDTOConverter
                        .convert(o))
                .collect(Collectors
                        .toList());
    }

    public OrderUpdateModel convert(OrderUpdateDTO orderDTO) {
        if (orderDTO == null) {
            return null;
        }
        return new OrderUpdateModel(
                orderDTO.getId(),
                orderDTO.getCustomerId(),
                orderDTO.getShopId(),
                orderDTO.getAddressId(),
                orderDTO.getOriginalPrice(),
                orderDTO.getTotalPrice(),
                orderDTO.getPaidFromBonus(),
                orderDTO.getPaymentType(),
                orderDTO.getOrderDiscount());
    }
}
