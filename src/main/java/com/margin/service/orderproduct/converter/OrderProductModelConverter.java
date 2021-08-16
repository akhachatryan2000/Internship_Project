package com.margin.service.orderproduct.converter;

import com.margin.controller.orderproduct.dto.OrderProductCreationDTO;
import com.margin.controller.orderproduct.dto.OrderProductDTO;
import com.margin.controller.orderproduct.dto.OrderProductUpdateDTO;
import com.margin.service.orderproduct.model.OrderProductCreationModel;
import com.margin.service.orderproduct.model.OrderProductModel;
import com.margin.service.orderproduct.model.OrderProductUpdateModel;
import org.springframework.stereotype.Component;

@Component
public class OrderProductModelConverter {

    public OrderProductDTO convert(OrderProductModel orderProductModel) {
        if (orderProductModel == null) {
            return null;
        }
        OrderProductDTO orderProductDTO = new OrderProductDTO();
        orderProductDTO.setProductId(orderProductModel.getProductId());
        orderProductDTO.setOrderId(orderProductModel.getOrderId());
        orderProductDTO.setId(orderProductModel.getId());
        orderProductDTO.setAmount(orderProductModel.getAmount());
        orderProductDTO.setComment(orderProductModel.getComment());
        orderProductDTO.setOriginalPrice(orderProductModel.getOriginalPrice());
        orderProductDTO.setDiscount(orderProductModel.getDiscount());
        orderProductDTO.setTotalPrice(orderProductModel.getTotalPrice());
        return orderProductDTO;
    }

    public OrderProductCreationDTO convert(OrderProductCreationModel orderProductModel) {
        if (orderProductModel == null) {
            return null;
        }
        OrderProductCreationDTO orderProductDTO = new OrderProductCreationDTO();
        orderProductDTO.setProductId(orderProductModel.getProductId());
        orderProductDTO.setOrderId(orderProductModel.getOrderId());
        orderProductDTO.setAmount(orderProductModel.getAmount());
        orderProductDTO.setComment(orderProductModel.getComment());
        orderProductDTO.setOriginalPrice(orderProductModel.getOriginalPrice());
        orderProductDTO.setDiscount(orderProductModel.getDiscount());
        orderProductDTO.setTotalPrice(orderProductModel.getTotalPrice());
        return orderProductDTO;

    }

    public OrderProductUpdateDTO convert(OrderProductUpdateModel orderProductModel) {
        if (orderProductModel == null) {
            return null;
        }
        OrderProductUpdateDTO orderProductDTO = new OrderProductUpdateDTO();
        orderProductDTO.setProductId(orderProductModel.getProductId());
        orderProductDTO.setOrderId(orderProductModel.getOrderId());
        orderProductDTO.setId(orderProductModel.getId());
        orderProductDTO.setAmount(orderProductModel.getAmount());
        orderProductDTO.setComment(orderProductModel.getComment());
        orderProductDTO.setOriginalPrice(orderProductModel.getOriginalPrice());
        orderProductDTO.setDiscount(orderProductModel.getDiscount());
        orderProductDTO.setTotalPrice(orderProductModel.getTotalPrice());
        return orderProductDTO;

    }
}
