package com.margin.repository.order.entity;

import com.margin.common.enums.PaymentType;
import com.margin.repository.address.entity.AddressEntity;
import com.margin.repository.address.entity.AddressUpdateEntity;
import com.margin.repository.customer.entity.CustomerEntity;
import com.margin.repository.customer.entity.CustomerUpdateEntity;
import com.margin.repository.orderproduct.entity.OrderProductCreationEntity;
import com.margin.repository.orderproduct.entity.OrderProductUpdateEntity;
import com.margin.repository.shop.entity.ShopEntity;
import com.margin.repository.shop.entity.ShopUpdateEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
@Setter
@Getter
public class OrderUpdateEntity {

    private List<OrderProductUpdateEntity> products;

    private CustomerUpdateEntity customer;

    private ShopUpdateEntity shop;

    private AddressUpdateEntity address;

    private BigDecimal originalPrice;

    private BigDecimal totalPrice;

    private BigDecimal paidFromBonus;

    private PaymentType paymentType;

    private BigDecimal orderDiscount;
}
