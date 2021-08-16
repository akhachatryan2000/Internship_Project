package com.margin.repository.order.entity;

import com.margin.common.enums.PaymentType;
import com.margin.repository.address.entity.AddressEntity;
import com.margin.repository.customer.entity.CustomerEntity;
import com.margin.repository.orderproduct.entity.OrderProductEntity;
import com.margin.repository.shop.entity.ShopEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Setter
@Getter
public class OrderEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "products")
    @OneToMany
    private List<OrderProductEntity> products;

    @Column(name = "customer")
    @ManyToOne
    private CustomerEntity customer;

    @Column(name="shop")

    @OneToMany
    private ShopEntity shop;

    @Column(name = "address")
    @OneToOne(fetch = FetchType.LAZY)
    private AddressEntity address;


    @Column(name = "original_price")
    private BigDecimal originalPrice;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "paid_from_bonus")
    private BigDecimal paidFromBonus;

    @Column(name = "payment_type")
    private PaymentType paymentType;

    @Column(name = "order_discount")
    private BigDecimal orderDiscount;

}