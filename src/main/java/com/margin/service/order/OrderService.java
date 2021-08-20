package com.margin.service.order;

import com.margin.repository.address.AddressRepository;
import com.margin.repository.address.entity.AddressEntity;
import com.margin.repository.customer.CustomerRepository;
import com.margin.repository.customer.entity.CustomerEntity;
import com.margin.repository.order.OrderRepository;
import com.margin.repository.order.entity.OrderEntity;
import com.margin.repository.shop.entity.ShopEntity;
import com.margin.repository.shop.entity.ShopRepository;
import com.margin.service.order.converter.OrderEntityConverter;
import com.margin.service.order.model.OrderCreationModel;
import com.margin.service.order.model.OrderModel;
import com.margin.service.order.model.OrderUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderEntityConverter orderEntityConverter;

    public OrderModel get(Long id) {
        OrderEntity orderEntity = orderRepository.getById(id);
        return orderEntityConverter.convert(orderEntity);
    }

    public OrderModel create(OrderCreationModel orderCreationModel) {
        OrderEntity orderEntity = orderEntityConverter.convert(orderCreationModel);
        OrderEntity orderCreated = orderRepository.save(orderEntity);
        AddressEntity addressEntity = addressRepository.getById(orderCreationModel.getAddressId());
        orderCreated.setAddress(addressEntity);
        CustomerEntity customer = customerRepository.getById(orderCreationModel.getCustomerId());
        orderCreated.setCustomer(customer);
        ShopEntity shop = shopRepository.getById(orderCreationModel.getShopId());
        orderCreated.setShop(shop);
        return orderEntityConverter.convert(orderCreated);
    }

    public OrderModel update(OrderUpdateModel orderUpdateModel, Long id) {
        OrderEntity orderEntity = orderRepository.getById(id);
        OrderEntity orderEntity1 = orderEntityConverter.convert(orderUpdateModel, orderEntity);
        OrderEntity order = orderRepository.save(orderEntity1);
        return orderEntityConverter.convert(order);
    }

    public Boolean delete(Long id) {
        orderRepository.deleteById(id);
        return true;
    }
}
