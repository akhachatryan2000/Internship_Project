package com.margin.service.facade;

import com.margin.service.order.OrderService;
import com.margin.service.order.model.OrderCreationModel;
import com.margin.service.order.model.OrderModel;
import com.margin.service.order.validator.OrderValidator;
import com.margin.service.orderproduct.OrderProductService;
import com.margin.service.orderproduct.model.OrderProductCreationModel;
import com.margin.service.orderproduct.model.OrderProductModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderFacade {

    private OrderService orderService;

    private OrderProductService orderProductService;

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
