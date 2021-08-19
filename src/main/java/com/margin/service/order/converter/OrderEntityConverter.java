package com.margin.service.order.converter;

import com.margin.repository.address.AddressRepository;
import com.margin.repository.customer.CustomerRepository;
import com.margin.repository.order.entity.OrderEntity;
import com.margin.repository.orderproduct.OrderProductRepository;
import com.margin.repository.orderproduct.entity.OrderProductEntity;
import com.margin.repository.shop.entity.ShopRepository;
import com.margin.service.order.model.OrderCreationModel;
import com.margin.service.order.model.OrderModel;
import com.margin.service.order.model.OrderUpdateModel;
import com.margin.service.orderproduct.converter.OrderProductEntityConverter;
import com.margin.service.orderproduct.model.OrderProductCreationModel;
import com.margin.service.orderproduct.model.OrderProductModel;
import com.margin.service.orderproduct.model.OrderProductUpdateModel;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderEntityConverter {

    @Autowired
    private OrderProductEntityConverter orderProductEntityConverter;


    @Autowired
    private OrderEntityConverter orderEntityConverter;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;


    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private OrderProductRepository orderProductRepository;

    public OrderModel convert(OrderEntity orderEntity) {
        if (orderEntity == null) {
            return null;
        }
        OrderModel orderModel = new OrderModel(
                orderEntity.getId(),
                orderEntityConverter.convert(orderEntity.getProducts()),
                orderEntity.getCustomer().getId(),
                orderEntity.getShop().getId(),
                orderEntity.getAddress().getId(),
                orderEntity.getOriginalPrice(),
                orderEntity.getTotalPrice(),
                orderEntity.getPaidFromBonus(),
                orderEntity.getPaymentType(),
                orderEntity.getOrderDiscount());
        return orderModel;

    }

    public List<OrderProductModel> convert(List<OrderProductEntity> orderProductEntities, OrderProductEntity orderEntity) {
        if (orderProductEntities == null) {
            return new ArrayList<>();
        }
        List<OrderProductModel> orderProductModels =
                orderEntity.()
                        .stream()
                        .map(orderProductEntity ->
                                orderProductEntityConverter.convert(orderProductEntity,))
                        .collect(Collectors.toList());
        return orderProductModels;

    }


    public OrderEntity convert(OrderCreationModel orderCreationModel) {
        if (orderCreationModel == null) {
            return null;
        }
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setAddress(addressRepository.getById(orderCreationModel.getAddressId()));
        orderEntity.setOrderDiscount(orderCreationModel.getOrderDiscount());
        orderEntity.setCustomer(customerRepository.getById(orderCreationModel.getCustomerId()));
        orderEntity.setPaymentType(orderCreationModel.getPaymentType());
        orderEntity.setProducts(orderEntityConverter.convert(orderCreationModel.getOrderProducts(), orderCreationModel));
        orderEntity.setPaidFromBonus(orderCreationModel.getPaidFromBonus());
        orderEntity.setTotalPrice(orderCreationModel.getTotalPrice());
        orderEntity.setOriginalPrice(orderCreationModel.getOriginalPrice());
        orderEntity.setShop(shopRepository.getById(orderCreationModel.getShopId()));
        return orderEntity;
    }

    public List<OrderProductEntity> convert(List<OrderProductCreationModel> orderProductCreationModels, OrderCreationModel orderCreationModel) {
        if (orderProductCreationModels == null) {
            return null;
        }
        List<OrderProductEntity> orderProductEntities = orderCreationModel.getOrderProducts()
                .stream()
                .map(op -> orderProductEntityConverter.convert(op)
                ).collect(Collectors.toList());
        return orderProductEntities;

    }

    public OrderEntity convert(OrderUpdateModel orderUpdateModel, OrderEntity orderEntity) {
        if (orderUpdateModel == null) {
            return null;
        }
        //orderEntity.getProducts().forEach(orderProductEntity -> orderProductRepository.getById(id));
        orderEntity.setShop(shopRepository.getById(orderUpdateModel.getShopId()));
        orderEntity.setOrderDiscount(orderUpdateModel.getOrderDiscount());
        orderEntity.setCustomer(customerRepository.getById(orderUpdateModel.getCustomerId()));
        orderEntity.setOriginalPrice(orderUpdateModel.getOriginalPrice());
        orderEntity.setTotalPrice(orderUpdateModel.getTotalPrice());
        orderEntity.setPaidFromBonus(orderUpdateModel.getPaidFromBonus());
        orderEntity.setPaymentType(orderUpdateModel.getPaymentType());
        orderEntity.setAddress(addressRepository.getById(orderUpdateModel.getAddressId()));
       // orderEntity.setProducts(orderEntityConverter.convert(orderUpdateModel.getOrderProducts(), ));
        return orderEntity;

    }

    public List<OrderProductEntity> convert(List<OrderProductUpdateModel> orderProductUpdateModels, OrderProductEntity orderProductEntity) {
        if (orderProductUpdateModels == null) {
            return null;
        }
        List<OrderProductEntity> orderProductEntities = orderProductUpdateModels
                .stream()
                .map(orderProductUpdateModel -> orderProductEntityConverter.convert(orderProductUpdateModel, orderProductEntity))
                .collect(Collectors.toList());
        return orderProductEntities;
    }
}
