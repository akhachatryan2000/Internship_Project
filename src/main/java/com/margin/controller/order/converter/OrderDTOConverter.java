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
        OrderModel orderModel = new OrderModel();
        orderModel.setCustomerId(orderDTO.getId());
        //orderModel.setOrderProductIds(orderDTO.getOrderProductIds());
        orderModel.setShopId(orderDTO.getShopId());
        orderModel.setOriginalPrice(orderDTO.getOriginalPrice());
        orderModel.setTotalPrice(orderDTO.getTotalPrice());
        orderModel.setPaidFromBonus(orderDTO.getPaidFromBonus());
        orderModel.setPaymentType(orderDTO.getPaymentType());
        orderModel.setOrderDiscount(orderDTO.getOrderDiscount());
        return orderModel;
    }

//    public List<OrderProductModel> convert(List<OrderProductDTO> orderProductDTOS, OrderDTO orderDTO) {
//        if (orderProductDTOS == null) {
//            return new ArrayList<>();
//        }
//        List<OrderProductModel> orderProductModels = orderDTO.getProducts()
//                .stream()
//                .map(o -> orderProductDTOConverter.convert(o))
//                .collect(Collectors.toList());
//        return orderProductModels;
//    }

    public OrderCreationModel convert(OrderCreationDTO orderDTO) {
        if (orderDTO == null) {
            return null;
        }
        OrderCreationModel orderModel = new OrderCreationModel();
       // orderModel.setProducts(orderDTOConverter.convert(orderDTO.getProducts(), orderDTO));
       // CustomerCreationModel customerModel = customerDTOConverter.convert(orderDTO.getCustomer());
       // orderModel.setCustomer(customerModel);
       // ShopCreationModel shopModel = shopDTOConverter.convert(orderDTO.getShop());
        //orderModel.setShop(shopModel);
        orderModel.setOriginalPrice(orderDTO.getOriginalPrice());
        orderModel.setTotalPrice(orderDTO.getTotalPrice());
        orderModel.setPaidFromBonus(orderDTO.getPaidFromBonus());
        orderModel.setPaymentType(orderDTO.getPaymentType());
        orderModel.setOrderDiscount(orderDTO.getOrderDiscount());
        return orderModel;

    }

//    public List<OrderProductCreationModel> convert(List<OrderProductCreationDTO> orderProductDTOS, OrderCreationDTO orderDTO) {
//        if (orderProductDTOS == null) {
//            return new ArrayList<>();
//        }
//        List<OrderProductCreationModel> orderProductModels = orderDTO.getProducts()
//                .stream().map(o -> orderProductDTOConverter.convert(o)).collect(Collectors.toList());
//        return orderProductModels;
//    }

    public OrderUpdateModel convert(OrderUpdateDTO orderDTO) {
        if (orderDTO == null) {
            return null;
        }
        OrderUpdateModel orderModel = new OrderUpdateModel();
      //  orderModel.setProducts(orderDTOConverter.convert(orderDTO.getProducts(), orderDTO));
        //CustomerUpdateModel customerUpdateModel = customerDTOConverter.convert(orderDTO.getCustomer());
        //orderModel.setCustomer(customerUpdateModel);
     //   ShopUpdateModel shopUpdateModel = shopDTOConverter.convert(orderDTO.getShop());
      //  orderModel.setShop(shopUpdateModel);
        orderModel.setOriginalPrice(orderDTO.getOriginalPrice());
        orderModel.setTotalPrice(orderDTO.getTotalPrice());
        orderModel.setPaidFromBonus(orderDTO.getPaidFromBonus());
        orderModel.setPaymentType(orderDTO.getPaymentType());
        orderModel.setOrderDiscount(orderDTO.getOrderDiscount());
        return orderModel;

    }

//    public List<OrderProductUpdateModel> convert(List<OrderProductUpdateDTO> orderProductDTOS, OrderUpdateDTO orderDTO) {
//        if (orderProductDTOS == null) {
//            return new ArrayList<>();
//        }
//        List<OrderProductUpdateModel> orderProductModels = orderDTO.getProducts()
//                .stream().map(o -> orderProductDTOConverter.convert(o)).collect(Collectors.toList());
//        return orderProductModels;
//    }

}
