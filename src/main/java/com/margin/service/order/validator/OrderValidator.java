package com.margin.service.order.validator;

import com.margin.service.order.model.OrderCreationModel;
import com.margin.service.order.model.OrderUpdateModel;
import com.margin.service.orderproduct.validator.OrderProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderValidator {

    @Autowired
    private OrderHasAddressValidator addressValidator;

    @Autowired
    private OrderHasCustomerValidator orderHasCustomer;

    @Autowired
    private OrderHasPaymentType orderHasPaymenttype;

    @Autowired
    private OrderHasTotalPrice orderHasTotalPrice;

    @Autowired
    private OrderHasShopValidator hasShopValidator;

    @Autowired
    private OriginalPriceValidator originalPriceValidator;

    @Autowired
    private OrderProductValidator orderProductValidator;

    @Autowired
    private PaidFromBonusValidator paidFromBonusValidator;

    @Autowired
    private OrderDiscountValidator discountValidator;


    public void orderIsValid(OrderCreationModel orderModel) {
        addressValidator.hasAddress(orderModel.getAddressId());
        hasShopValidator.hasShop(orderModel.getShopId());
        orderHasCustomer.orderHasCustomer(orderModel.getCustomerId());
        orderHasPaymenttype.orderHasPaymentType(orderModel.getPaymentType());
        orderHasTotalPrice.orderHasTotalPrice(orderModel.getTotalPrice());
        originalPriceValidator.hasOriginalPrice(orderModel.getOriginalPrice());
        paidFromBonusValidator.paidFromBonus(orderModel.getPaidFromBonus());
        discountValidator.hasOrderDiscount(orderModel.getOrderDiscount());
        orderModel.getOrderProducts().forEach(opm -> orderProductValidator.orderProductIsValid(opm));
    }

    public void orderIsValid(OrderUpdateModel orderModel) {
        addressValidator.hasAddress(orderModel.getAddressId());
        hasShopValidator.hasShop(orderModel.getShopId());
        orderHasCustomer.orderHasCustomer(orderModel.getCustomerId());
        orderHasPaymenttype.orderHasPaymentType(orderModel.getPaymentType());
        originalPriceValidator.hasOriginalPrice(orderModel.getOriginalPrice());
        paidFromBonusValidator.paidFromBonus(orderModel.getPaidFromBonus());
        orderHasTotalPrice.orderHasTotalPrice(orderModel.getTotalPrice());
        discountValidator.hasOrderDiscount(orderModel.getOrderDiscount());
    }
}

