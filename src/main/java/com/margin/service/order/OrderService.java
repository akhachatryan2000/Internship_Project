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
import com.margin.service.order.converter.OrderModelConverter;
import com.margin.service.order.model.OrderCreationModel;
import com.margin.service.order.model.OrderModel;
import com.margin.service.order.model.OrderUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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

    @Autowired
    private OrderModelConverter orderModelConverter;

    public OrderModel get(Long id) {
        OrderEntity orderEntity = orderRepository.getById(id);
        return orderEntityConverter.convert(orderEntity);
    }

    @Transactional
    public OrderModel create(OrderCreationModel orderCreationModel) {
        OrderEntity orderEntity = orderModelConverter.convert(orderCreationModel);
        AddressEntity addressEntity = addressRepository.getById(orderCreationModel.getAddressId());
        orderEntity.setAddress(addressEntity);
        CustomerEntity customer = customerRepository.getById(orderCreationModel.getCustomerId());
        orderEntity.setCustomer(customer);
        ShopEntity shop = shopRepository.getById(orderCreationModel.getShopId());
        orderEntity.setShop(shop);
        orderEntity = orderRepository.save(orderEntity);
        return orderEntityConverter.convert(orderEntity);
    }

    @Transactional
    public OrderModel update(OrderUpdateModel orderUpdateModel, Long id) {
        OrderEntity orderEntity = orderRepository.getById(id);
        orderEntity = orderModelConverter.convert(orderUpdateModel, orderEntity);
        orderEntity = orderRepository.save(orderEntity);
        return orderEntityConverter.convert(orderEntity);
    }

    public Boolean delete(Long id) {
        orderRepository.deleteById(id);
        return true;
    }
}
