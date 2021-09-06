package com.margin.service.orderproduct.validator;

import com.margin.service.orderproduct.model.OrderProductCreationModel;
import com.margin.service.orderproduct.model.OrderProductUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrderProductValidator {

    @Autowired
    private OrderProductHasOrderIdValidator orderId;

    @Autowired
    private OrderProductHasProductIdValidator productIdValidator;

    @Autowired
    private OrderProductHasTotalPriceValidator totalPriceValidator;

    @Autowired
    private OrderProductOriginalPriceValidator orderProductOriginalPriceValidator;

    @Autowired
    private DiscountValidator discountValidator;

    public void orderProductIsValid(OrderProductCreationModel orderProductModel) {
        orderId.orderProductHasOrderId(orderProductModel.getOrderId());
        productIdValidator.orderProductHasProductId(orderProductModel.getProductId());
        totalPriceValidator.hasTotalPrice(orderProductModel.getTotalPrice());
        orderProductOriginalPriceValidator.hasOriginalPrice(orderProductModel.getOriginalPrice());
        discountValidator.hasDiscount(orderProductModel.getDiscount());
    }

    public void orderProductIsValid(OrderProductUpdateModel orderProductModel) {
        orderId.orderProductHasOrderId(orderProductModel.getOrderId());
        productIdValidator.orderProductHasProductId(orderProductModel.getProductId());
        totalPriceValidator.hasTotalPrice(orderProductModel.getTotalPrice());
        orderProductOriginalPriceValidator.hasOriginalPrice(orderProductModel.getOriginalPrice());
        discountValidator.hasDiscount(orderProductModel.getDiscount());
    }
}
