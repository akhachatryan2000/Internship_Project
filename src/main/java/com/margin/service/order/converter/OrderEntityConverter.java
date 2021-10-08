package com.margin.service.order.converter;

import com.margin.entity.OrderEntity;
import com.margin.service.order.model.OrderModel;
import com.margin.service.orderproduct.converter.OrderProductEntityConverter;
import com.margin.service.orderproduct.model.OrderProductModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class OrderEntityConverter {

    private OrderProductEntityConverter orderProductEntityConverter;

    public OrderModel convert(OrderEntity orderEntity) {
        if (orderEntity == null) {
            return null;
        }
        List<OrderProductModel> orderProducts = orderProductEntityConverter.convert(orderEntity.getProducts());
        return new OrderModel(
                orderEntity.getId(),
                orderProducts,
                getCustomerId(orderEntity),
                getShopId(orderEntity),
                getAddressId(orderEntity),
                orderEntity.getOriginalPrice(),
                orderEntity.getTotalPrice(),
                orderEntity.getPaidFromBonus(),
                orderEntity.getPaymentType(),
                orderEntity.getOrderDiscount());
    }

    public Long getAddressId(OrderEntity orderEntity) {
        if (orderEntity == null) {
            return null;
        }
        return orderEntity.getAddress() == null ? null : orderEntity.getAddress().getId();
    }

    public Long getShopId(OrderEntity orderEntity) {
        if (orderEntity == null) {
            return null;
        }
        return orderEntity.getShop() == null ? null : orderEntity.getShop().getId();
    }

    public Long getCustomerId(OrderEntity orderEntity) {
        if (orderEntity == null) {
            return null;
        }
        return orderEntity.getCustomer() == null ? null : orderEntity.getCustomer().getId();
    }
}
