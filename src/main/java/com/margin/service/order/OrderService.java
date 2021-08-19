package com.margin.service.order;

import com.margin.repository.order.OrderRepository;
import com.margin.repository.order.entity.OrderEntity;
import com.margin.service.OrderFacade;
import com.margin.service.order.converter.OrderEntityConverter;
import com.margin.service.order.converter.OrderModelConverter;
import com.margin.service.order.model.OrderCreationModel;
import com.margin.service.order.model.OrderModel;
import com.margin.service.order.model.OrderUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderEntityConverter orderEntityConverter;

    @Autowired
    private OrderFacade orderFacade;

    @Autowired
    private OrderModelConverter orderModelConverter;

    public OrderModel get(Long id) {
        try {
            OrderEntity orderEntity = orderRepository.getById(id);
            OrderModel orderModel = orderEntityConverter.convert(orderEntity);
            return orderModel;
        } catch (EntityNotFoundException exception) {
            System.out.println("No such element to retrieve");
        }

        return null;
    }

    public OrderModel create(OrderCreationModel orderCreationModel) {
        OrderModel order = orderFacade.createOrder(orderCreationModel);
         OrderEntity orderEntity = orderEntityConverter.convert(order);
         OrderEntity orderCreated = orderRepository.save(orderEntity);
         OrderModel orderModel = orderEntityConverter.convert(orderCreated);
        return null;
    }

    public OrderModel update(OrderUpdateModel orderUpdateModel, Long id) {
        try {
            OrderEntity orderEntity = orderRepository.getById(id);
            OrderEntity orderEntity1 = orderEntityConverter.convert(orderUpdateModel, orderEntity);
            OrderModel orderModel = orderEntityConverter.convert(orderEntity1);
            return orderModel;

        } catch (EntityNotFoundException exception) {
            System.out.println("There is no such entity to update");
        }
        return null;
    }

    public Boolean delete(Long id) {
        try {
            orderRepository.deleteById(id);
            return true;

        } catch (EntityNotFoundException exception) {
            System.out.println("No such entity to delete");
        }
        return null;
    }

}
