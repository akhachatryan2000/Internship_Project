package com.margin.service.orderproduct.converter;

import com.margin.entity.OrderProductEntity;
import com.margin.service.orderproduct.model.OrderProductModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class OrderProductEntityConverter {

    public OrderProductModel convert(OrderProductEntity orderProductEntity) {
        if (orderProductEntity == null) {
            return null;
        }
        return new OrderProductModel(
                orderProductEntity.getId(),
                orderProductEntity.getOrderId(),
                orderProductEntity.getProductId(),
                orderProductEntity.getTotalPrice(),
                orderProductEntity.getAmount(),
                orderProductEntity.getComment(),
                orderProductEntity.getOriginalPrice(),
                orderProductEntity.getDiscount());
    }

    public List<OrderProductModel> convert(List<OrderProductEntity> orderProductEntities) {
        if (orderProductEntities == null) {
            return new ArrayList<>();
        }
        return orderProductEntities
                .stream()
                .filter(Objects::nonNull)
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
