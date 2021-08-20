package com.margin.controller.orderproduct.converter;

import com.margin.controller.orderproduct.dto.OrderProductCreationDTO;
import com.margin.controller.orderproduct.dto.OrderProductDTO;
import com.margin.controller.orderproduct.dto.OrderProductUpdateDTO;
import com.margin.service.orderproduct.model.OrderProductCreationModel;
import com.margin.service.orderproduct.model.OrderProductModel;
import com.margin.service.orderproduct.model.OrderProductUpdateModel;
import org.springframework.stereotype.Component;

@Component
public class OrderProductDTOConverter {

    public OrderProductModel convert(OrderProductDTO orderProductDTO) {
        if (orderProductDTO == null) {
            return null;
        }
        return new OrderProductModel(
                orderProductDTO.getId(),
                orderProductDTO.getOrderId(),
                orderProductDTO.getProductId(),
                orderProductDTO.getTotalPrice(),
                orderProductDTO.getAmount(),
                orderProductDTO.getComment(),
                orderProductDTO.getOriginalPrice(),
                orderProductDTO.getDiscount());
    }

    public OrderProductCreationModel convert(OrderProductCreationDTO orderProductDTO) {
        if (orderProductDTO == null) {
            return null;
        }
        return new OrderProductCreationModel(
                orderProductDTO.getOrderId(),
                orderProductDTO.getProductId(),
                orderProductDTO.getTotalPrice(),
                orderProductDTO.getAmount(),
                orderProductDTO.getComment(),
                orderProductDTO.getOriginalPrice(),
                orderProductDTO.getDiscount());
    }

    public OrderProductUpdateModel convert(OrderProductUpdateDTO orderProductDTO) {
        if (orderProductDTO == null) {
            return null;
        }
        return new OrderProductUpdateModel(
                orderProductDTO.getId(),
                orderProductDTO.getOrderId(),
                orderProductDTO.getProductId(),
                orderProductDTO.getTotalPrice(),
                orderProductDTO.getAmount(),
                orderProductDTO.getComment(),
                orderProductDTO.getOriginalPrice(),
                orderProductDTO.getDiscount());
    }
}

