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
import com.margin.service.orderproduct.converter.OrderProductModelConverter;
import com.margin.service.orderproduct.model.OrderProductCreationModel;
import com.margin.service.orderproduct.model.OrderProductModel;
import com.margin.service.orderproduct.model.OrderProductUpdateModel;
import com.margin.service.shop.converter.ShopModelConverter;
import com.margin.service.shop.model.ShopCreationModel;
import com.margin.service.shop.model.ShopUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderModelConverter {

    public OrderDTO convert(OrderModel orderModel) {
        if (orderModel == null) {
            return null;
        }
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(orderModel.getId());
        orderDTO.setOrderDiscount(orderModel.getOrderDiscount());
        orderDTO.setCustomerId(orderModel.getCustomerId());
        orderDTO.setAddressId(orderModel.getAddressId());
        orderDTO.setPaymentType(orderModel.getPaymentType());
        orderDTO.setPaidFromBonus(orderModel.getPaidFromBonus());
        orderDTO.setTotalPrice(orderModel.getTotalPrice());
        orderDTO.setOriginalPrice(orderModel.getOriginalPrice());
       // orderDTO.setOrderProductIds(orderModel.getOrderProductIds());
        orderDTO.setShopId(orderModel.getShopId());
        return orderDTO;
    }

    public OrderCreationDTO convert(OrderCreationModel orderModel) {
        if (orderModel == null) {
            return null;
        }
        OrderCreationDTO orderDTO = new OrderCreationDTO();
       // orderDTO.setOrderProductIds(orderModel.getOrderProductIds());
        orderDTO.setCustomerId(orderModel.getCustomerId());
        orderDTO.setShopId(orderModel.getShopId());
        orderDTO.setOriginalPrice(orderModel.getOriginalPrice());
        orderDTO.setTotalPrice(orderModel.getTotalPrice());
        orderDTO.setPaidFromBonus(orderModel.getPaidFromBonus());
        orderDTO.setPaymentType(orderModel.getPaymentType());
        orderDTO.setOrderDiscount(orderModel.getOrderDiscount());
        orderDTO.setShopId(orderModel.getShopId());
        return orderDTO;

    }

    public OrderUpdateDTO convert(OrderUpdateModel orderModel) {
        if (orderModel == null) {
            return null;
        }
        OrderUpdateDTO orderDTO=new OrderUpdateDTO();
        orderDTO.setId(orderModel.getId());
       // orderDTO.setOrderProductIds(orderModel.getOrderProductIds());
        orderDTO.setCustomerId(orderModel.getCustomerId());
        orderDTO.setShopId(orderModel.getShopId());
        orderDTO.setOriginalPrice(orderModel.getOriginalPrice());
        orderDTO.setTotalPrice(orderModel.getTotalPrice());
        orderDTO.setPaidFromBonus(orderModel.getPaidFromBonus());
        orderDTO.setPaymentType(orderModel.getPaymentType());
        orderDTO.setOrderDiscount(orderModel.getOrderDiscount());
        orderDTO.setShopId(orderModel.getShopId());
        return orderDTO;

    }

//    public List<OrderProductDTO> convert(List<OrderProductModel> orderProductModels, OrderModel orderModel) {
//        if (orderProductModels == null) {
//            return new ArrayList<>();
//        }
//        List<OrderProductDTO> orderProductDTOS = orderModel.getProducts().stream()
//                .map(orderProductModel -> orderProductModelConverter
//                        .convert(orderProductModel)).collect(Collectors.toList());
//        return orderProductDTOS;
//    }



//    public List<OrderProductCreationDTO> convert(List<OrderProductCreationModel> orderProductModels, OrderCreationModel orderModel) {
//        if (orderProductModels == null) {
//            return new ArrayList<>();
//        }
//        List<OrderProductCreationDTO> orderProductDTOS = orderModel.getProducts().stream()
//                .map(orderProductModel -> orderProductModelConverter
//                        .convert(orderProductModel)).collect(Collectors.toList());
//        return orderProductDTOS;
//    }


//    public List<OrderProductUpdateDTO> convert(List<OrderProductUpdateModel> orderProductModels, OrderUpdateModel orderModel) {
//        if (orderProductModels == null) {
//            return new ArrayList<>();
//        }
//        List<OrderProductUpdateDTO> orderProductDTOS = orderModel.getProducts().stream()
//                .map(orderProductModel -> orderProductModelConverter
//                        .convert(orderProductModel)).collect(Collectors.toList());
//        return orderProductDTOS;
//    }
}
