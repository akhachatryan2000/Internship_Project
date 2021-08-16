package com.margin.repository.orderproduct.converter;
import com.margin.repository.orderproduct.entity.OrderProductCreationEntity;
import com.margin.repository.orderproduct.entity.OrderProductEntity;
import com.margin.repository.orderproduct.entity.OrderProductUpdateEntity;
import com.margin.service.orderproduct.model.OrderProductCreationModel;
import com.margin.service.orderproduct.model.OrderProductModel;
import com.margin.service.orderproduct.model.OrderProductUpdateModel;
import org.springframework.stereotype.Component;



@Component
public class OrderProductEntityConverter {
    public OrderProductModel convert(OrderProductEntity orderProductEntity) {
        if (orderProductEntity==null) {
            return null;
        }
        OrderProductModel orderProductModel = new OrderProductModel();
        orderProductModel.setProductId(orderProductEntity.getProductId());
        orderProductModel.setOrderId(orderProductEntity.getOrderId());
        orderProductModel.setId(orderProductEntity.getId());
        orderProductModel.setAmount(orderProductEntity.getAmount());
        orderProductModel.setComment(orderProductEntity.getComment());
        orderProductModel.setOriginalPrice(orderProductEntity.getOriginalPrice());
        orderProductModel.setDiscount(orderProductEntity.getDiscount());
        orderProductModel.setTotalPrice(orderProductEntity.getTotalPrice());
        return orderProductModel;

    }
    public OrderProductCreationModel convert(OrderProductCreationEntity orderProductEntity) {
        if (orderProductEntity==null) {
            return null;
        }
        OrderProductCreationModel orderProductModel = new OrderProductCreationModel();
        orderProductModel.setProductId(orderProductEntity.getProductId());
        orderProductModel.setOrderId(orderProductEntity.getOrderId());
        orderProductModel.setAmount(orderProductEntity.getAmount());
        orderProductModel.setComment(orderProductEntity.getComment());
        orderProductModel.setOriginalPrice(orderProductEntity.getOriginalPrice());
        orderProductModel.setDiscount(orderProductEntity.getDiscount());
        orderProductModel.setTotalPrice(orderProductEntity.getTotalPrice());
        return orderProductModel;

    }
    public OrderProductUpdateModel convert(OrderProductUpdateEntity orderProductEntity) {
        if (orderProductEntity==null) {
            return null;
        }
        OrderProductUpdateModel orderProductModel= new OrderProductUpdateModel();
        orderProductModel.setProductId(orderProductEntity.getProductId());
        orderProductModel.setOrderId(orderProductEntity.getOrderId());
        orderProductModel.setId(orderProductEntity.getId());
        orderProductModel.setAmount(orderProductEntity.getAmount());
        orderProductModel.setComment(orderProductEntity.getComment());
        orderProductModel.setOriginalPrice(orderProductEntity.getOriginalPrice());
        orderProductModel.setDiscount(orderProductEntity.getDiscount());
        orderProductModel.setTotalPrice(orderProductEntity.getTotalPrice());
        return orderProductModel;

    }



}
