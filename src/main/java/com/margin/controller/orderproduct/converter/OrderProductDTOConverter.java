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
        if (orderProductDTO==null) {
            return null;
        }
        OrderProductModel orderProductModel = new OrderProductModel();
        orderProductModel.setProductId(orderProductDTO.getProductId());
        orderProductModel.setOrderId(orderProductDTO.getOrderId());
        orderProductModel.setId(orderProductDTO.getId());
        orderProductModel.setAmount(orderProductDTO.getAmount());
        orderProductModel.setComment(orderProductDTO.getComment());
        orderProductModel.setOriginalPrice(orderProductDTO.getOriginalPrice());
        orderProductModel.setDiscount(orderProductDTO.getDiscount());
        orderProductModel.setTotalPrice(orderProductDTO.getTotalPrice());
        return orderProductModel;


    }


        public OrderProductCreationModel convert(OrderProductCreationDTO orderProductCreationDTO) {
            if (orderProductCreationDTO==null) {
                return null;
            }
        OrderProductCreationModel orderProductModel = new OrderProductCreationModel();
        orderProductModel.setProductId(orderProductCreationDTO.getProductId());
        orderProductModel.setOrderId(orderProductCreationDTO.getOrderId());
        orderProductModel.setAmount(orderProductCreationDTO.getAmount());
        orderProductModel.setComment(orderProductCreationDTO.getComment());
        orderProductModel.setOriginalPrice(orderProductCreationDTO.getOriginalPrice());
        orderProductModel.setDiscount(orderProductCreationDTO.getDiscount());
        orderProductModel.setTotalPrice(orderProductCreationDTO.getTotalPrice());
        return orderProductModel;

    }

    public OrderProductUpdateModel convert(OrderProductUpdateDTO orderProductUpdateDTO) {
        if (orderProductUpdateDTO==null) {
            return null;
        }
        OrderProductUpdateModel orderProduct = new OrderProductUpdateModel();
        orderProduct.setId(orderProductUpdateDTO.getId());
        orderProduct.setProductId(orderProductUpdateDTO.getProductId());
        orderProduct.setOrderId(orderProductUpdateDTO.getOrderId());
        orderProduct.setAmount(orderProductUpdateDTO.getAmount());
        orderProduct.setComment(orderProductUpdateDTO.getComment());
        orderProduct.setOriginalPrice(orderProductUpdateDTO.getOriginalPrice());
        orderProduct.setDiscount(orderProductUpdateDTO.getDiscount());
        orderProduct.setTotalPrice(orderProductUpdateDTO.getTotalPrice());
        return orderProduct;
    }
}

