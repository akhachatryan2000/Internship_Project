package com.margin.repository.order.entity;

import com.margin.common.enums.PaymentType;
import com.margin.repository.address.entity.AddressCreationEntity;
import com.margin.repository.address.entity.AddressEntity;
import com.margin.repository.customer.entity.CustomerCreationEntity;
import com.margin.repository.customer.entity.CustomerEntity;
import com.margin.repository.orderproduct.entity.OrderProductCreationEntity;
import com.margin.repository.shop.entity.ShopCreationEntity;
import com.margin.repository.shop.entity.ShopEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
public class OrderCreationEntity {

    private List<OrderProductCreationEntity> products;

    private CustomerCreationEntity customer;

    private ShopCreationEntity shop;

    private AddressCreationEntity address;

    private BigDecimal originalPrice;

    private BigDecimal totalPrice;

    private BigDecimal paidFromBonus;

    private PaymentType paymentType;

    private BigDecimal orderDiscount;
}
