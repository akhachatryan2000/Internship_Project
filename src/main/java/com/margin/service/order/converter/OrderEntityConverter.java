package com.margin.service.order.converter;

import com.margin.repository.order.entity.OrderEntity;
import com.margin.repository.orderproduct.entity.OrderProductEntity;
import com.margin.service.order.model.OrderCreationModel;
import com.margin.service.order.model.OrderModel;
import com.margin.service.order.model.OrderUpdateModel;
import com.margin.service.orderproduct.converter.OrderProductEntityConverter;
import com.margin.service.orderproduct.model.OrderProductCreationModel;
import com.margin.service.orderproduct.model.OrderProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderEntityConverter {

    @Autowired
    private OrderProductEntityConverter orderProductEntityConverter;

    @Autowired
    private OrderEntityConverter orderEntityConverter;

    public OrderModel convert(OrderEntity orderEntity) {
        if (orderEntity == null) {
            return null;
        }
        return new OrderModel(
                orderEntity.getId(),
                orderEntityConverter.convert(orderEntity.getProducts(), orderEntity),
                orderEntity.getCustomer().getId(),
                orderEntity.getShop().getId(),
                orderEntity.getAddress().getId(),
                orderEntity.getOriginalPrice(),
                orderEntity.getTotalPrice(),
                orderEntity.getPaidFromBonus(),
                orderEntity.getPaymentType(),
                orderEntity.getOrderDiscount());
    }

    public List<OrderProductModel> convert(List<OrderProductEntity> orderProductEntities, OrderEntity orderEntity) {
        if (orderProductEntities == null) {
            return new ArrayList<>();
        }
        return orderEntity.getProducts()
                .stream()
                .map(orderProductEntity ->
                        orderProductEntityConverter.convert(orderProductEntity))
                .collect(Collectors.toList());
    }

    public OrderEntity convert(OrderCreationModel orderCreationModel) {
        if (orderCreationModel == null) {
            return null;
        }
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderDiscount(orderCreationModel.getOrderDiscount());
        orderEntity.setPaymentType(orderCreationModel.getPaymentType());
        orderEntity.setProducts(orderEntityConverter.convert(orderCreationModel.getOrderProducts(), orderCreationModel));
        orderEntity.setPaidFromBonus(orderCreationModel.getPaidFromBonus());
        orderEntity.setTotalPrice(orderCreationModel.getTotalPrice());
        orderEntity.setOriginalPrice(orderCreationModel.getOriginalPrice());
        return orderEntity;
    }

    public List<OrderProductEntity> convert(List<OrderProductCreationModel> orderProductCreationModels, OrderCreationModel orderCreationModel) {
        if (orderProductCreationModels == null) {
            return null;
        }
        return orderCreationModel.getOrderProducts()
                .stream()
                .map(op -> orderProductEntityConverter.convert(op)
                ).collect(Collectors.toList());
    }

    public OrderEntity convert(OrderUpdateModel orderUpdateModel, OrderEntity orderEntity) {
        if (orderUpdateModel == null) {
            return null;
        }
        orderEntity.setOrderDiscount(orderUpdateModel.getOrderDiscount());
        orderEntity.setOriginalPrice(orderUpdateModel.getOriginalPrice());
        orderEntity.setTotalPrice(orderUpdateModel.getTotalPrice());
        orderEntity.setPaidFromBonus(orderUpdateModel.getPaidFromBonus());
        orderEntity.setPaymentType(orderUpdateModel.getPaymentType());
        return orderEntity;
    }
}
