package com.margin.service.orderproduct.converter;


import com.margin.repository.orderproduct.entity.OrderProductEntity;
import com.margin.service.orderproduct.model.OrderProductCreationModel;
import com.margin.service.orderproduct.model.OrderProductModel;
import com.margin.service.orderproduct.model.OrderProductUpdateModel;
import org.springframework.stereotype.Component;

@Component
public class OrderProductEntityConverter {

    public OrderProductModel convert(OrderProductEntity orderProductEntity) {
        if (orderProductEntity == null) {
            return null;
        }
        OrderProductModel orderProductModel = new OrderProductModel();
        orderProductModel.setProductId(orderProductEntity.getProductId());
        orderProductModel.setOrderId(orderProductEntity.getOrderId());
        orderProductModel.setId(orderProductEntity.getId());
        orderProductModel.setTotalPrice(orderProductEntity.getTotalPrice());
        orderProductModel.setOriginalPrice(orderProductEntity.getOriginalPrice());
        orderProductModel.setAmount(orderProductModel.getAmount());
        orderProductModel.setDiscount(orderProductModel.getDiscount());
        orderProductModel.setComment(orderProductEntity.getComment());
        return orderProductModel;

    }

    public OrderProductEntity convert(OrderProductModel orderProductModel) {
        if (orderProductModel == null) {
            return null;
        }
        OrderProductEntity orderProductEntity = new OrderProductEntity();
        orderProductEntity.setProductId(orderProductModel.getProductId());
        orderProductEntity.setOrderId(orderProductModel.getOrderId());
        orderProductEntity.setAmount(orderProductModel.getAmount());
        orderProductEntity.setId(orderProductModel.getId());
        orderProductEntity.setComment(orderProductModel.getComment());
        orderProductEntity.setDiscount(orderProductModel.getDiscount());
        orderProductEntity.setTotalPrice(orderProductModel.getDiscount());
        orderProductEntity.setOriginalPrice(orderProductModel.getOriginalPrice());
        return orderProductEntity;
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
        if (orderProductUpdateModel == null) {
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
}
