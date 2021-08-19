package com.margin.service.orderproduct.converter;


import com.margin.repository.orderproduct.entity.OrderProductEntity;
import com.margin.service.orderproduct.model.OrderProductCreationModel;
import com.margin.service.orderproduct.model.OrderProductModel;
import com.margin.service.orderproduct.model.OrderProductUpdateModel;
import org.springframework.stereotype.Component;

@Component
public class OrderProductEntityConverter {

    public OrderProductModel convert(OrderProductUpdateModel orderProductEntity) {
        if (orderProductEntity == null) {
            return null;
        }
        OrderProductModel orderProductModel = new OrderProductModel(
                orderProductEntity.getId(),
                orderProductEntity.getOrderId(),
                orderProductEntity.getProductId(),
                orderProductEntity.getTotalPrice(),
                orderProductEntity.getAmount(),
                orderProductEntity.getComment(),
                orderProductEntity.getOriginalPrice(),
                orderProductEntity.getDiscount()
        );

        return orderProductModel;

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
