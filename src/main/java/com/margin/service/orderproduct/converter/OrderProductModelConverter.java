package com.margin.service.orderproduct.converter;

import com.margin.controller.orderproduct.dto.OrderProductDTO;
import com.margin.entity.OrderProductEntity;
import com.margin.service.orderproduct.model.OrderProductCreationModel;
import com.margin.service.orderproduct.model.OrderProductModel;
import com.margin.service.orderproduct.model.OrderProductUpdateModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class OrderProductModelConverter {

    public OrderProductDTO convert(OrderProductModel orderProductModel) {
        if (orderProductModel == null) {
            return null;
        }
        return new OrderProductDTO(
                orderProductModel.getId(),
                orderProductModel.getOrderId(),
                orderProductModel.getProductId(),
                orderProductModel.getTotalPrice(),
                orderProductModel.getAmount(),
                orderProductModel.getComment(),
                orderProductModel.getOriginalPrice(),
                orderProductModel.getDiscount());
    }

    public OrderProductEntity convert(OrderProductCreationModel orderProductCreationModel) {
        if (orderProductCreationModel == null) {
            return null;
        }
        OrderProductEntity orderProductEntity = new OrderProductEntity();
        orderProductEntity.setProductId(orderProductCreationModel.getProductId());
        orderProductEntity.setOrderId(orderProductCreationModel.getOrderId());
        orderProductEntity.setOriginalPrice(orderProductCreationModel.getOriginalPrice());
        orderProductEntity.setComment(orderProductCreationModel.getComment());
        orderProductEntity.setDiscount(orderProductCreationModel.getDiscount());
        orderProductEntity.setTotalPrice(orderProductCreationModel.getTotalPrice());
        orderProductEntity.setAmount(orderProductCreationModel.getAmount());
        return orderProductEntity;
    }

    public OrderProductEntity convert(OrderProductUpdateModel orderProductUpdateModel, OrderProductEntity orderProductEntity) {
        if (orderProductUpdateModel == null && orderProductEntity == null) {
            return null;
        }
        orderProductEntity.setProductId(orderProductUpdateModel.getProductId());
        orderProductEntity.setOrderId(orderProductUpdateModel.getOrderId());
        orderProductEntity.setAmount(orderProductUpdateModel.getAmount());
        orderProductEntity.setDiscount(orderProductUpdateModel.getDiscount());
        orderProductEntity.setComment(orderProductUpdateModel.getComment());
        orderProductEntity.setTotalPrice(orderProductUpdateModel.getTotalPrice());
        orderProductEntity.setOriginalPrice(orderProductUpdateModel.getOriginalPrice());
        return orderProductEntity;
    }

    public List<OrderProductEntity> convert(List<OrderProductCreationModel> models) {
        if (models == null) {
            return new ArrayList<>();
        }
        return models
                .stream()
                .filter(Objects::nonNull)
                .map(this::convert).collect(Collectors.toList());
    }

    public List<OrderProductDTO> convertModels(List<OrderProductModel> models) {
        if (models == null) {
            return null;
        }
        return models
                .stream()
                .filter(Objects::nonNull)
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
