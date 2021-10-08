package com.margin.service.order.converter;

import com.margin.controller.order.dto.OrderDTO;
import com.margin.controller.orderproduct.dto.OrderProductDTO;
import com.margin.entity.OrderEntity;
import com.margin.service.order.model.OrderCreationModel;
import com.margin.service.order.model.OrderModel;
import com.margin.service.order.model.OrderUpdateModel;
import com.margin.service.orderproduct.converter.OrderProductModelConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class OrderModelConverter {

    private OrderProductModelConverter orderProductModelConverter;

    public OrderDTO convert(OrderModel orderModel) {
        if (orderModel == null) {
            return null;
        }
        List<OrderProductDTO> orderProductDTOS = orderProductModelConverter.convertModels(orderModel.getOrderProducts());
        return new OrderDTO(
                orderModel.getId(),
                orderProductDTOS,
                orderModel.getCustomerId(),
                orderModel.getShopId(),
                orderModel.getAddressId(),
                orderModel.getOriginalPrice(),
                orderModel.getTotalPrice(),
                orderModel.getPaidFromBonus(),
                orderModel.getPaymentType(),
                orderModel.getOrderDiscount());
    }

    public OrderEntity convert(OrderCreationModel model) {
        if (model == null) {
            return null;
        }
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderDiscount(model.getOrderDiscount());
        orderEntity.setPaymentType(model.getPaymentType());
        orderEntity.setPaidFromBonus(model.getPaidFromBonus());
        orderEntity.setTotalPrice(model.getTotalPrice());
        orderEntity.setOriginalPrice(model.getOriginalPrice());
        return orderEntity;
    }

    public OrderEntity convert(OrderUpdateModel model, OrderEntity orderEntity) {
        if (model == null && orderEntity == null) {
            return null;
        }
        orderEntity.setOrderDiscount(model.getOrderDiscount());
        orderEntity.setTotalPrice(model.getTotalPrice());
        orderEntity.setOriginalPrice(model.getOriginalPrice());
        orderEntity.setPaymentType(model.getPaymentType());
        orderEntity.setPaidFromBonus(model.getPaidFromBonus());
        return orderEntity;
    }
}
