package com.margin.service.order.converter;

import com.margin.controller.order.dto.OrderCreationDTO;
import com.margin.controller.order.dto.OrderDTO;
import com.margin.controller.order.dto.OrderUpdateDTO;
import com.margin.controller.orderproduct.dto.OrderProductCreationDTO;
import com.margin.controller.orderproduct.dto.OrderProductDTO;
import com.margin.service.order.model.OrderCreationModel;
import com.margin.service.order.model.OrderModel;
import com.margin.service.order.model.OrderUpdateModel;
import com.margin.service.orderproduct.converter.OrderProductModelConverter;
import com.margin.service.orderproduct.model.OrderProductCreationModel;
import com.margin.service.orderproduct.model.OrderProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderModelConverter {

    @Autowired
    private OrderProductModelConverter orderProductModelConverter;

    @Autowired
    private OrderModelConverter orderModelConverter;

    public OrderDTO convert(OrderModel orderModel) {
        if (orderModel == null) {
            return null;
        }
        return new OrderDTO(
                orderModel.getId(),
                orderModelConverter.convert(orderModel.getOrderProducts(), orderModel),
                orderModel.getCustomerId(),
                orderModel.getShopId(),
                orderModel.getAddressId(),
                orderModel.getOriginalPrice(),
                orderModel.getTotalPrice(),
                orderModel.getPaidFromBonus(),
                orderModel.getPaymentType(),
                orderModel.getOrderDiscount());
    }

    public OrderUpdateDTO convert(OrderUpdateModel orderModel) {
        if (orderModel == null) {
            return null;
        }
        return new OrderUpdateDTO(
                orderModel.getId(),
                //orderModelConverter.convert(orderModel.getOrderProducts(), orderModel),
                orderModel.getCustomerId(),
                orderModel.getShopId(),
                orderModel.getAddressId(),
                orderModel.getOriginalPrice(),
                orderModel.getTotalPrice(),
                orderModel.getPaidFromBonus(),
                orderModel.getPaymentType(),
                orderModel.getOrderDiscount());
    }

    public List<OrderProductDTO> convert(List<OrderProductModel> orderProductModels, OrderModel orderModel) {
        if (orderProductModels == null) {
            return new ArrayList<>();
        }
        return orderModel.getOrderProducts()
                .stream()
                .map(orderProductModel
                        -> orderProductModelConverter
                        .convert(orderProductModel))
                .collect(Collectors.toList());
    }
}
