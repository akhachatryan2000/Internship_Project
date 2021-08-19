package com.margin.controller.order.converter;

import com.margin.controller.customer.converter.CustomerDTOConverter;
import com.margin.controller.order.dto.OrderCreationDTO;
import com.margin.controller.order.dto.OrderDTO;
import com.margin.controller.order.dto.OrderUpdateDTO;
import com.margin.controller.orderproduct.converter.OrderProductDTOConverter;
import com.margin.controller.orderproduct.dto.OrderProductCreationDTO;
import com.margin.controller.orderproduct.dto.OrderProductDTO;
import com.margin.controller.orderproduct.dto.OrderProductUpdateDTO;
import com.margin.controller.shop.converter.ShopDTOConverter;
import com.margin.service.customer.model.CustomerCreationModel;
import com.margin.service.customer.model.CustomerModel;
import com.margin.service.customer.model.CustomerUpdateModel;
import com.margin.service.order.model.OrderCreationModel;
import com.margin.service.order.model.OrderModel;
import com.margin.service.order.model.OrderUpdateModel;
import com.margin.service.orderproduct.model.OrderProductCreationModel;
import com.margin.service.orderproduct.model.OrderProductModel;
import com.margin.service.orderproduct.model.OrderProductUpdateModel;
import com.margin.service.shop.model.ShopCreationModel;
import com.margin.service.shop.model.ShopModel;
import com.margin.service.shop.model.ShopUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderDTOConverter {

    @Autowired
    private CustomerDTOConverter customerDTOConverter;
    @Autowired
    private ShopDTOConverter shopDTOConverter;
    @Autowired
    private OrderProductDTOConverter orderProductDTOConverter;
    @Autowired
    private OrderDTOConverter orderDTOConverter;


    public OrderModel convert(OrderDTO orderDTO) {
        if (orderDTO == null) {
            return null;
        }
        OrderModel orderModel = new OrderModel(
                orderDTO.getId(),
                orderDTOConverter.convertList(orderDTO.getOrderProducts(), orderDTO),
                orderDTO.getCustomerId(),
                orderDTO.getShopId(),
                orderDTO.getAddressId(),
                orderDTO.getOriginalPrice(),
                orderDTO.getTotalPrice(),
                orderDTO.getPaidFromBonus(),
                orderDTO.getPaymentType(),
                orderDTO.getOrderDiscount());


        return orderModel;
    }

    public List<OrderProductModel> convertList(List<OrderProductDTO> orderProductDTOS, OrderDTO orderDTO) {
        if (orderProductDTOS == null) {
            return new ArrayList<>();
        }
        List<OrderProductModel> orderProductModels = orderDTO.getOrderProducts()
                .stream()
                .map(orderProductDTO -> orderProductDTOConverter
                        .convert(orderProductDTO))
                .collect(Collectors.toList());
        return orderProductModels;

    }

    public OrderCreationModel convert(OrderCreationDTO orderDTO) {
        if (orderDTO == null) {
            return null;
        }
        OrderCreationModel orderModel = new OrderCreationModel(
                orderDTOConverter.convertList(orderDTO.getOrderProducts(), orderDTO),
                orderDTO.getCustomerId(),
                orderDTO.getShopId(),
                orderDTO.getAddressId(),
                orderDTO.getOriginalPrice(),
                orderDTO.getTotalPrice(),
                orderDTO.getPaidFromBonus(),
                orderDTO.getPaymentType(),
                orderDTO.getOrderDiscount());

        return orderModel;

    }

    public List<OrderProductCreationModel> convertList(List<OrderProductCreationDTO> orderProductDTOS, OrderCreationDTO orderDTO) {
        if (orderProductDTOS == null) {
            return new ArrayList<>();
        }
        List<OrderProductCreationModel> orderProductModels = orderDTO.getOrderProducts()
                .stream()
                .map(o -> orderProductDTOConverter
                        .convert(o))
                .collect(Collectors
                        .toList());
        return orderProductModels;
    }

    public OrderUpdateModel convert(OrderUpdateDTO orderDTO) {
        if (orderDTO == null) {
            return null;
        }
        OrderUpdateModel orderModel = new OrderUpdateModel(
                orderDTO.getId(),
                orderDTOConverter.convert(orderDTO.getOrderProducts(), orderDTO),
                orderDTO.getCustomerId(),
                orderDTO.getShopId(),
                orderDTO.getAddressId(),
                orderDTO.getOriginalPrice(),
                orderDTO.getTotalPrice(),
                orderDTO.getPaidFromBonus(),
                orderDTO.getPaymentType(),
                orderDTO.getOrderDiscount()
        );

        return orderModel;

    }

    public List<OrderProductUpdateModel> convert(List<OrderProductUpdateDTO> orderProductDTOS, OrderUpdateDTO orderDTO) {
        if (orderProductDTOS == null) {
            return new ArrayList<>();
        }
        List<OrderProductUpdateModel> orderProductModels = orderDTO.getOrderProducts()
                .stream().map(o -> orderProductDTOConverter
                        .convert(o)).collect(Collectors.toList());
        return orderProductModels;
    }

}
