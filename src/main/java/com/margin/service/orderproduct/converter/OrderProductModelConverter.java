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
        OrderProductDTO orderProductDTO = new OrderProductDTO(
                orderProductModel.getId(),
                orderProductModel.getOrderId(),
                orderProductModel.getProductId(),
                orderProductModel.getTotalPrice(),
                orderProductModel.getAmount(),
                orderProductModel.getComment(),
                orderProductModel.getOriginalPrice(),
                orderProductModel.getDiscount()
        );
        return orderProductDTO;
    }

    public OrderProductCreationDTO convert(OrderProductCreationModel orderProductModel) {
        if (orderProductModel == null) {
            return null;
        }
        OrderProductCreationDTO orderProductDTO = new OrderProductCreationDTO(
                orderProductModel.getOrderId(),
                orderProductModel.getProductId(),
                orderProductModel.getTotalPrice(),
                orderProductModel.getAmount(),
                orderProductModel.getComment(),
                orderProductModel.getOriginalPrice(),
                orderProductModel.getDiscount()
        );

        return orderProductDTO;

    }

    public OrderProductUpdateDTO convert(OrderProductUpdateModel orderProductModel) {
        if (orderProductModel == null) {
            return null;
        }
        OrderProductUpdateDTO orderProductDTO = new OrderProductUpdateDTO(
                orderProductModel.getId(),
                orderProductModel.getOrderId(),
                orderProductModel.getProductId(),
                orderProductModel.getTotalPrice(),
                orderProductModel.getAmount(),
                orderProductModel.getComment(),
                orderProductModel.getOriginalPrice(),
                orderProductModel.getDiscount()
        );
        return orderProductDTO;

    }
}
