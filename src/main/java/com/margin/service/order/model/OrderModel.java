package com.margin.service.order.model;

import com.margin.common.enums.PaymentType;
import com.margin.service.address.model.AddressModel;
import com.margin.service.customer.model.CustomerModel;
import com.margin.service.orderproduct.model.OrderProductModel;
import com.margin.service.shop.model.ShopModel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
@Getter
@Setter
public class OrderModel {

    private List<OrderProductModel> products;

    private CustomerModel customer;

    private ShopModel shop;

    private AddressModel address;

    private BigDecimal originalPrice;

    private BigDecimal totalPrice;

    private BigDecimal paidFromBonus;

    private PaymentType paymentType;

    private BigDecimal orderDiscount;
}
