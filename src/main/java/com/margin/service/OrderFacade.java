package com.margin.service;

import com.margin.service.order.OrderService;
import com.margin.service.order.model.OrderCreationModel;
import com.margin.service.order.model.OrderModel;
import com.margin.service.orderproduct.OrderProductService;
import com.margin.service.orderproduct.model.OrderProductCreationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderFacade {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderProductService orderProductService;

    public OrderModel createOrder(OrderCreationModel orderCreationModel) {
        OrderModel orderModel = orderService.create(orderCreationModel);
        List<OrderProductCreationModel> orderProductCreationModels = orderCreationModel.getOrderProducts();
        orderProductCreationModels.forEach(orderProductCreationModel -> orderProductCreationModel.setOrderId(orderModel.getId()));
        for (OrderProductCreationModel orderProduct : orderProductCreationModels) {
            orderProductService.create(orderProduct);
        }
        return orderModel;
    }
}
