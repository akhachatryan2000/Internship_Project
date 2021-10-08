package com.margin.service.order;

import com.margin.entity.AddressEntity;
import com.margin.entity.CustomerEntity;
import com.margin.entity.OrderEntity;
import com.margin.entity.ShopEntity;
import com.margin.repository.address.AddressRepository;
import com.margin.repository.customer.CustomerRepository;
import com.margin.repository.order.OrderRepository;
import com.margin.repository.orderproduct.OrderProductRepository;
import com.margin.repository.shop.ShopRepository;
import com.margin.service.order.converter.OrderEntityConverter;
import com.margin.service.order.converter.OrderModelConverter;
import com.margin.service.order.model.OrderCreationModel;
import com.margin.service.order.model.OrderModel;
import com.margin.service.order.model.OrderUpdateModel;
import com.margin.service.order.validator.OrderValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderService {

    private CustomerRepository customerRepository;

    private AddressRepository addressRepository;

    private ShopRepository shopRepository;

    private OrderRepository orderRepository;

    private OrderEntityConverter orderEntityConverter;

    private OrderModelConverter orderModelConverter;

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
        AddressEntity addressEntity = addressRepository.findByIdAndDeletedIsFalse(orderCreationModel.getAddressId())
                .orElseThrow(() -> new EntityNotFoundException("Address with this id does not exist"));
        orderEntity.setAddress(addressEntity);
        CustomerEntity customer = customerRepository.findByIdAndDeletedIsFalse(orderCreationModel.getCustomerId())
                .orElseThrow(() -> new EntityNotFoundException("Customer with this id does not exist"));
        orderEntity.setCustomer(customer);
        ShopEntity shop = shopRepository.findByIdAndDeletedIsFalse(orderCreationModel.getShopId())
                .orElseThrow(() -> new EntityNotFoundException("Shop with this id does not exist"));
        orderEntity.setShop(shop);
        orderEntity = orderRepository.save(orderEntity);
        return orderEntityConverter.convert(orderEntity);
    }

    @Transactional
    public OrderModel update(OrderUpdateModel orderUpdateModel, Long id) {
        OrderEntity orderEntity = orderRepository.findByIdAndDeletedIsFalse(id)
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

    public List<OrderModel> getAll() {
        List<OrderEntity> orderEntities = orderRepository.findAllOrdered();
        return orderEntities
                .stream()
                .map(orderEntity -> orderEntityConverter.convert(orderEntity))
                .collect(Collectors.toList());
    }
}
