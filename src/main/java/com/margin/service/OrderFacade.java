package com.margin.service;

import com.margin.repository.address.AddressRepository;
import com.margin.repository.address.entity.AddressEntity;
import com.margin.repository.customer.CustomerRepository;
import com.margin.repository.customer.entity.CustomerEntity;
import com.margin.repository.order.OrderRepository;
import com.margin.repository.order.entity.OrderEntity;
import com.margin.repository.shop.entity.ShopEntity;
import com.margin.repository.shop.entity.ShopRepository;
import com.margin.service.order.OrderService;
import com.margin.service.order.converter.OrderEntityConverter;
import com.margin.service.order.converter.OrderModelConverter;
import com.margin.service.order.model.OrderCreationModel;
import com.margin.service.order.model.OrderModel;
import com.margin.service.orderproduct.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderFacade {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderProductService orderProductService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private OrderModelConverter orderModelConverter;

    @Autowired
    private OrderEntityConverter orderEntityConverter;


    public OrderModel createOrder(OrderCreationModel orderCreationModel) {
        OrderModel orderModel = orderService.create(orderCreationModel);
        AddressEntity addressEntity = addressRepository.getById(orderCreationModel.getAddressId());
        CustomerEntity customerEntity = customerRepository.getById(orderCreationModel.getCustomerId());
        ShopEntity shopEntity = shopRepository.getById(orderCreationModel.getShopId());
        OrderEntity orderEntity = orderEntityConverter.convert(orderCreationModel);
        orderEntity.setAddress(addressEntity);
        orderEntity.setCustomer(customerEntity);
        orderEntity.setShop(shopEntity);
        orderEntity = orderRepository.save(orderEntity);
        //orderCreationModel.getOrderProducts().forEach(orderProduct -> orderProduct.setOrderId(orderEntity.getId()));

        return orderEntityConverter.convert(orderEntity);


    }


}
