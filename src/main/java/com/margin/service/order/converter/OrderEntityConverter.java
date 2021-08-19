package com.margin.service.order.converter;

import com.margin.repository.order.entity.OrderEntity;
import com.margin.repository.orderproduct.entity.OrderProductEntity;
import com.margin.service.order.model.OrderCreationModel;
import com.margin.service.order.model.OrderModel;
import com.margin.service.order.model.OrderUpdateModel;
import com.margin.service.orderproduct.converter.OrderProductEntityConverter;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderEntityConverter {

    @Autowired
    private OrderProductEntityConverter orderProductEntityConverter;

    public OrderModel convert(OrderEntity orderEntity) {
        if (orderEntity == null) {
            return null;
        }
        OrderModel orderModel = new OrderModel();
        orderModel.setId(orderEntity.getId());
        orderModel.setOrderDiscount(orderEntity.getOrderDiscount());
        orderModel.setPaymentType(orderEntity.getPaymentType());
        orderModel.setTotalPrice(orderEntity.getTotalPrice());
        orderModel.setOriginalPrice(orderEntity.getOriginalPrice());
        orderModel.setPaidFromBonus(orderEntity.getPaidFromBonus());
        //orderModel.setCustomerId(orderEntity.getCustomer());
        //  orderModel.setAddressId(orderEntity.getAddress());
        // orderModel.setShopId(orderEntity.getShop());
//        for (OrderProductEntity orderProduct:orderEntity.getProducts()) {
//            List<Long> orderProductIds=new ArrayList<>();
//            orderProductIds.add(orderProduct.getProductId());
//        orderModel.setOrderProductIds(orderEntity.getProducts());
        return orderModel;

    }

    public OrderEntity convert(OrderModel orderModel) {
        if (orderModel == null) {
            return null;
        }
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(orderModel.getId());
        orderEntity.setOrderDiscount(orderModel.getOrderDiscount());
        orderEntity.setOriginalPrice(orderModel.getOriginalPrice());
        orderEntity.setTotalPrice(orderModel.getTotalPrice());
        //orderEntity.setCustomer(orderModel.getCustomerId());
        orderEntity.setPaidFromBonus(orderModel.getPaidFromBonus());
        // orderEntity.setAddress(orderModel.getAddressId());
        //orderEntity.setShop(orderModel.getShopId());
        orderEntity.setPaymentType(orderModel.getPaymentType());
        // orderEntity.setProducts(orderModel.getOrderProductIds());
        return orderEntity;
    }

    public OrderEntity convert(OrderCreationModel orderCreationModel) {
        if (orderCreationModel == null) {
            return null;
        }
        OrderEntity orderEntity = new OrderEntity();
        //  orderEntity.setAddress(orderCreationModel.getAddressId());
        orderEntity.setOrderDiscount(orderCreationModel.getOrderDiscount());
        //orderEntity.setCustomer(orderCreationModel.getCustomerId());
        orderEntity.setPaymentType(orderCreationModel.getPaymentType());
        //orderEntity.setProducts(orderCreationModel.getOrderProductIds());
        orderEntity.setPaidFromBonus(orderCreationModel.getPaidFromBonus());
        orderEntity.setTotalPrice(orderCreationModel.getTotalPrice());
        orderEntity.setOriginalPrice(orderCreationModel.getOriginalPrice());
        //orderEntity.setShop(orderCreationModel.getShopId());
        return orderEntity;
    }

    public OrderEntity convert(OrderUpdateModel orderUpdateModel, OrderEntity orderEntity) {
        if (orderUpdateModel == null) {
            return null;
        }
        // orderEntity.setShop(orderUpdateModel.getShopId());
        orderEntity.setOrderDiscount(orderUpdateModel.getOrderDiscount());
        // orderEntity.setCustomer(orderUpdateModel.getCustomerId());
        orderEntity.setOriginalPrice(orderUpdateModel.getOriginalPrice());
        orderEntity.setTotalPrice(orderUpdateModel.getTotalPrice());
        orderEntity.setPaidFromBonus(orderUpdateModel.getPaidFromBonus());
        orderEntity.setPaymentType(orderUpdateModel.getPaymentType());
        //orderEntity.setAddress(orderUpdateModel.getAddressId());
        // orderEntity.setProducts(orderUpdateModel.getOrderProductIds());
        return orderEntity;

    }
}
