package com.margin.service.order.converter;

import com.margin.controller.address.dto.AddressDTO;
import com.margin.controller.customer.dto.CustomerCreationDTO;
import com.margin.controller.customer.dto.CustomerDTO;
import com.margin.controller.customer.dto.CustomerUpdateDTO;
import com.margin.controller.order.dto.OrderCreationDTO;
import com.margin.controller.order.dto.OrderDTO;
import com.margin.controller.order.dto.OrderUpdateDTO;
import com.margin.controller.orderproduct.dto.OrderProductCreationDTO;
import com.margin.controller.orderproduct.dto.OrderProductDTO;
import com.margin.controller.orderproduct.dto.OrderProductUpdateDTO;
import com.margin.controller.shop.dto.ShopCreationDTO;
import com.margin.controller.shop.dto.ShopUpdateDTO;
import com.margin.service.address.converter.AddressModelConverter;
import com.margin.service.address.model.AddressModel;
import com.margin.service.customer.converter.CustomerModelConverter;
import com.margin.service.customer.model.CustomerCreationModel;
import com.margin.service.customer.model.CustomerModel;
import com.margin.service.customer.model.CustomerUpdateModel;
import com.margin.service.order.model.OrderCreationModel;
import com.margin.service.order.model.OrderModel;
import com.margin.service.order.model.OrderUpdateModel;
import com.margin.service.orderproduct.converter.OrderProductEntityConverter;
import com.margin.service.orderproduct.converter.OrderProductModelConverter;
import com.margin.service.orderproduct.model.OrderProductCreationModel;
import com.margin.service.orderproduct.model.OrderProductModel;
import com.margin.service.orderproduct.model.OrderProductUpdateModel;
import com.margin.service.shop.converter.ShopModelConverter;
import com.margin.service.shop.model.ShopCreationModel;
import com.margin.service.shop.model.ShopUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderModelConverter {


    @Autowired
    private OrderProductModelConverter orderProductModelConverter;

    @Autowired
    private OrderModelConverter orderModelConverter;

    public OrderDTO convert(OrderModel orderModel) {
        if (orderModel == null) {
            return null;
        }
        OrderDTO orderDTO = new OrderDTO(
                orderModel.getId(),
                orderModelConverter.convert(orderModel.getOrderProducts(), orderModel),
                orderModel.getCustomerId(),
                orderModel.getShopId(),
                orderModel.getAddressId(),
                orderModel.getOriginalPrice(),
                orderModel.getTotalPrice(),
                orderModel.getPaidFromBonus(),
                orderModel.getPaymentType(),
                orderModel.getOrderDiscount()
        );
        return orderDTO;
    }

    public OrderCreationDTO convert(OrderCreationModel orderModel) {
        if (orderModel == null) {
            return null;
        }
        OrderCreationDTO orderDTO = new OrderCreationDTO(
                orderModelConverter.convert(orderModel.getOrderProducts(), orderModel),
                orderModel.getCustomerId(),
                orderModel.getShopId(),
                orderModel.getAddressId(),
                orderModel.getOriginalPrice(),
                orderModel.getTotalPrice(),
                orderModel.getPaidFromBonus(),
                orderModel.getPaymentType(),
                orderModel.getOrderDiscount()

        );
        return orderDTO;

    }

    public OrderUpdateDTO convert(OrderUpdateModel orderModel) {
        if (orderModel == null) {
            return null;
        }
        OrderUpdateDTO orderDTO = new OrderUpdateDTO(
                orderModel.getId(),
                orderModelConverter.convert(orderModel.getOrderProducts(), orderModel),
                orderModel.getCustomerId(),
                orderModel.getShopId(),
                orderModel.getAddressId(),
                orderModel.getOriginalPrice(),
                orderModel.getTotalPrice(),
                orderModel.getPaidFromBonus(),
                orderModel.getPaymentType(),
                orderModel.getOrderDiscount()
        );

        return orderDTO;

    }

    public List<OrderProductDTO> convert(List<OrderProductModel> orderProductModels, OrderModel orderModel) {
        if (orderProductModels == null) {
            return new ArrayList<>();
        }
        List<OrderProductDTO> orderProductDTOS = orderModel.getOrderProducts()
                .stream()
                .map(orderProductModel
                        -> orderProductModelConverter
                        .convert(orderProductModel))
                .collect(Collectors.toList());
        return orderProductDTOS;
    }


    public List<OrderProductCreationDTO> convert(List<OrderProductCreationModel> orderProductModels, OrderCreationModel orderModel) {
        if (orderProductModels == null) {
            return new ArrayList<>();
        }
        List<OrderProductCreationDTO> orderProductDTOS = orderModel.getOrderProducts()
                .stream()
                .map(orderProductModel
                        -> orderProductModelConverter
                        .convert(orderProductModel)).collect(Collectors.toList());
        return orderProductDTOS;
    }


    public List<OrderProductUpdateDTO> convert(List<OrderProductUpdateModel> orderProductModels, OrderUpdateModel orderModel) {
        if (orderProductModels == null) {
            return new ArrayList<>();
        }
        List<OrderProductUpdateDTO> orderProductDTOS = orderModel.getOrderProducts().stream()
                .map(orderProductModel -> orderProductModelConverter
                        .convert(orderProductModel))
                .collect(Collectors.toList());
        return orderProductDTOS;
    }
}
