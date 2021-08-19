package com.margin.controller.orderproduct.converter;

import com.margin.controller.orderproduct.dto.OrderProductCreationDTO;
import com.margin.controller.orderproduct.dto.OrderProductDTO;
import com.margin.controller.orderproduct.dto.OrderProductUpdateDTO;
import com.margin.service.orderproduct.model.OrderProductCreationModel;
import com.margin.service.orderproduct.model.OrderProductModel;
import com.margin.service.orderproduct.model.OrderProductUpdateModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderProductDTOConverter {

    public OrderProductModel convert(OrderProductDTO orderProductDTO) {
        if (orderProductDTO == null) {
            return null;
        }
        OrderProductModel orderProductModel = new OrderProductModel(
                orderProductDTO.getId(),
                orderProductDTO.getOrderId(),
                orderProductDTO.getProductId(),
                orderProductDTO.getTotalPrice(),
                orderProductDTO.getAmount(),
                orderProductDTO.getComment(),
                orderProductDTO.getOriginalPrice(),
                orderProductDTO.getDiscount()
        );

        return orderProductModel;


    }


    public OrderProductCreationModel convert(OrderProductCreationDTO orderProductDTO) {
        if (orderProductDTO == null) {
            return null;
        }
        OrderProductCreationModel orderProductModel = new OrderProductCreationModel(
                orderProductDTO.getOrderId(),
                orderProductDTO.getProductId(),
                orderProductDTO.getTotalPrice(),
                orderProductDTO.getAmount(),
                orderProductDTO.getComment(),
                orderProductDTO.getOriginalPrice(),
                orderProductDTO.getDiscount()
        );

        return orderProductModel;

    }

    public OrderProductUpdateModel convert(OrderProductUpdateDTO orderProductDTO) {
        if (orderProductDTO == null) {
            return null;
        }
        OrderProductUpdateModel orderProduct = new OrderProductUpdateModel(
                orderProductDTO.getId(),
                orderProductDTO.getOrderId(),
                orderProductDTO.getProductId(),
                orderProductDTO.getTotalPrice(),
                orderProductDTO.getAmount(),
                orderProductDTO.getComment(),
                orderProductDTO.getOriginalPrice(),
                orderProductDTO.getDiscount()
        );
        return orderProduct;

    }
}

