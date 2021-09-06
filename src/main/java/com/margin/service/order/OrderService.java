package com.margin.service.order;

import com.margin.repository.address.AddressRepository;
import com.margin.repository.address.entity.AddressEntity;
import com.margin.repository.customer.CustomerRepository;
import com.margin.repository.customer.entity.CustomerEntity;
import com.margin.repository.order.OrderRepository;
import com.margin.repository.order.entity.OrderEntity;
import com.margin.repository.orderproduct.OrderProductRepository;
import com.margin.repository.shop.entity.ShopEntity;
import com.margin.repository.shop.ShopRepository;
import com.margin.service.order.converter.OrderEntityConverter;
import com.margin.service.order.converter.OrderModelConverter;
import com.margin.service.order.model.OrderCreationModel;
import com.margin.service.order.model.OrderModel;
import com.margin.service.order.model.OrderUpdateModel;
import com.margin.service.order.validator.OrderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

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

    @Autowired
    private OrderProductRepository orderProduct;

    @Autowired
    private OrderValidator orderValidator;

    public OrderModel get(Long id) {
        OrderEntity orderEntity = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order with " + id + " id does not exist"));
        return orderEntityConverter.convert(orderEntity);
    }

    @Transactional
    public OrderModel create(OrderCreationModel orderCreationModel) {
        orderValidator.orderIsValid(orderCreationModel);
        OrderEntity orderEntity = orderModelConverter.convert(orderCreationModel);
        AddressEntity addressEntity = addressRepository.findById(orderCreationModel.getAddressId())
                .orElseThrow(() -> new EntityNotFoundException("Address with this id does not exist"));
        orderEntity.setAddress(addressEntity);
        CustomerEntity customer = customerRepository.findById(orderCreationModel.getCustomerId())
                .orElseThrow(() -> new EntityNotFoundException("Customer with this id does not exist"));
        orderEntity.setCustomer(customer);
        ShopEntity shop = shopRepository.findById(orderCreationModel.getShopId())
                .orElseThrow(() -> new EntityNotFoundException("Shop with this id does not exist"));
        orderEntity.setShop(shop);
        orderEntity = orderRepository.save(orderEntity);
        return orderEntityConverter.convert(orderEntity);
    }

    @Transactional
    public OrderModel update(OrderUpdateModel orderUpdateModel, Long id) {
        OrderEntity orderEntity = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order with this id does not exist"));
        orderValidator.orderIsValid(orderUpdateModel);
        orderEntity = orderModelConverter.convert(orderUpdateModel, orderEntity);
        orderEntity = orderRepository.save(orderEntity);
        return orderEntityConverter.convert(orderEntity);
    }

    public Boolean delete(Long id) {
        orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order with this id does not exist"));
        orderRepository.deleteUpdated(id);
        return true;
    }
}
