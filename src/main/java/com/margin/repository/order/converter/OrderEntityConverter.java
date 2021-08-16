package com.margin.repository.order.converter;

import com.margin.controller.order.dto.OrderCreationDTO;
import com.margin.controller.order.dto.OrderDTO;
import com.margin.repository.customer.converter.CustomerEntityConverter;
import com.margin.repository.order.entity.OrderCreationEntity;
import com.margin.repository.order.entity.OrderEntity;
import com.margin.repository.order.entity.OrderUpdateEntity;
import com.margin.repository.orderproduct.converter.OrderProductEntityConverter;
import com.margin.repository.orderproduct.entity.OrderProductCreationEntity;
import com.margin.repository.orderproduct.entity.OrderProductEntity;
import com.margin.repository.orderproduct.entity.OrderProductUpdateEntity;
import com.margin.repository.shop.converter.ShopEntityConverter;
import com.margin.repository.shop.entity.ShopEntity;
import com.margin.service.customer.model.CustomerCreationModel;
import com.margin.service.customer.model.CustomerModel;
import com.margin.service.customer.model.CustomerUpdateModel;
import com.margin.service.order.model.OrderCreationModel;
import com.margin.service.order.model.OrderModel;
import com.margin.service.order.model.OrderUpdateModel;
import com.margin.service.orderproduct.model.OrderProductCreationModel;
import com.margin.service.orderproduct.model.OrderProductModel;
import com.margin.service.orderproduct.model.OrderProductUpdateModel;
import com.margin.service.product.converter.ProductModelConverter;
import com.margin.service.shop.model.ShopCreationModel;
import com.margin.service.shop.model.ShopModel;
import com.margin.service.shop.model.ShopUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderEntityConverter {
    @Autowired
    private OrderProductEntityConverter orderProductEntityConverter;
    @Autowired
    private CustomerEntityConverter customerEntityConverter;
    @Autowired
    private ShopEntityConverter shopEntityConverter;
    @Autowired
    private OrderEntityConverter orderEntityConverter;

    public OrderModel convert(OrderEntity orderEntity) {
        if (orderEntity == null) {
            return null;
        }
        OrderModel orderModel = new OrderModel();

        orderModel.setProducts(orderEntityConverter.convert(orderEntity.getProducts(), orderEntity));
        CustomerModel customerModel = customerEntityConverter.convert(orderEntity.getCustomer());
        orderModel.setCustomer(customerModel);
        ShopModel shopModel = shopEntityConverter.convert(orderEntity.getShop());
        orderModel.setShop(shopModel);
        orderModel.setOriginalPrice(orderEntity.getOriginalPrice());
        orderModel.setTotalPrice(orderEntity.getTotalPrice());
        orderModel.setPaidFromBonus(orderEntity.getPaidFromBonus());
        orderModel.setPaymentType(orderEntity.getPaymentType());
        orderModel.setOrderDiscount(orderEntity.getOrderDiscount());
        return orderModel;
    }

    public List<OrderProductModel> convert(List<OrderProductEntity> orderProductEntities, OrderEntity orderEntity) {

        if (orderProductEntities == null) {
            return new ArrayList<>();
        }
        List<OrderProductModel> orderProductModels = orderEntity.getProducts().stream()
                .map(o -> orderProductEntityConverter.convert(o)).collect(Collectors.toList());
        return orderProductModels;

    }

    public OrderCreationModel convert(OrderCreationEntity orderEntity) {
        if (orderEntity == null) {
            return null;
        }
        OrderCreationModel orderModel = new OrderCreationModel();
        orderModel.setProducts(orderEntityConverter.convert(orderEntity.getProducts(), orderEntity));
        CustomerCreationModel customerCreationModel = customerEntityConverter.convert(orderEntity.getCustomer());
        orderModel.setCustomer(customerCreationModel);
        ShopCreationModel shopCreationModel = shopEntityConverter.convert(orderEntity.getShop());
        orderModel.setShop(shopCreationModel);
        orderModel.setOriginalPrice(orderEntity.getOriginalPrice());
        orderModel.setTotalPrice(orderEntity.getTotalPrice());
        orderModel.setPaidFromBonus(orderEntity.getPaidFromBonus());
        orderModel.setPaymentType(orderEntity.getPaymentType());
        orderModel.setOrderDiscount(orderEntity.getOrderDiscount());
        return orderModel;

    }

    public List<OrderProductCreationModel> convert(List<OrderProductCreationEntity> orderProductEntities, OrderCreationEntity orderEntity) {
        if (orderProductEntities == null) {
            return new ArrayList<>();
        }
        List<OrderProductCreationModel> orderProductModels = orderEntity.getProducts().stream()
                .map(o -> orderProductEntityConverter.convert(o)).collect(Collectors.toList());
        return orderProductModels;

    }

    public OrderUpdateModel convert(OrderUpdateEntity orderEntity) {
        if (orderEntity == null) {
            return null;
        }
        OrderUpdateModel orderModel = new OrderUpdateModel();
        orderModel.setProducts(orderEntityConverter.convert(orderEntity.getProducts(), orderEntity));
        CustomerUpdateModel customerUpdateModel = customerEntityConverter.convert(orderEntity.getCustomer());
        orderModel.setCustomer(customerUpdateModel);
        ShopUpdateModel shopModel = shopEntityConverter.convert(orderEntity.getShop());
        orderModel.setShop(shopModel);
        orderModel.setOriginalPrice(orderEntity.getOriginalPrice());
        orderModel.setTotalPrice(orderEntity.getTotalPrice());
        orderModel.setPaidFromBonus(orderEntity.getPaidFromBonus());
        orderModel.setPaymentType(orderEntity.getPaymentType());
        orderModel.setOrderDiscount(orderEntity.getOrderDiscount());
        return orderModel;

    }

    public List<OrderProductUpdateModel> convert(List<OrderProductUpdateEntity> orderProductEntities, OrderUpdateEntity orderEntity) {
        if (orderProductEntities == null) {
            return new ArrayList<>();
        }
        List<OrderProductUpdateModel> orderProductModels = orderEntity.getProducts().stream()
                .map(o -> orderProductEntityConverter.convert(o)).collect(Collectors.toList());
        return orderProductModels;

    }
}
