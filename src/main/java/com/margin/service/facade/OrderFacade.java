package com.margin.service.facade;

import com.margin.service.order.OrderService;
import com.margin.service.order.model.OrderCreationModel;
import com.margin.service.order.model.OrderModel;
import com.margin.service.order.validator.OrderValidator;
import com.margin.service.orderproduct.OrderProductService;
import com.margin.service.orderproduct.model.OrderProductCreationModel;
import com.margin.service.orderproduct.model.OrderProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class OrderFacade {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderProductService orderProductService;

    @Autowired
    private OrderValidator orderValidator;

    public OrderModel createOrder(OrderCreationModel orderCreationModel) {
        if (orderCreationModel == null) {
            return null;
        }
        orderValidator.orderIsValid(orderCreationModel);
        OrderModel orderModel = orderService.create(orderCreationModel);
        List<OrderProductCreationModel> orderProductCreationModels = orderCreationModel.getOrderProducts();
        orderProductCreationModels.forEach(orderProductCreationModel -> orderProductCreationModel.setOrderId(orderModel.getId()));
        List<OrderProductModel> orderProductModels = orderProductService.saveAll(orderProductCreationModels);
        orderModel.setOrderProducts(orderProductModels);
        return orderModel;
    }
}
