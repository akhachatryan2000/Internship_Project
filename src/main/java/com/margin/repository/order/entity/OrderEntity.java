package com.margin.repository.order.entity;

import com.margin.common.enums.PaymentType;
import com.margin.repository.address.entity.AddressEntity;
import com.margin.repository.customer.entity.CustomerEntity;
import com.margin.repository.orderproduct.entity.OrderProductEntity;
import com.margin.repository.shop.entity.ShopEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "OrderEntity")
@Table(name = "order")
@Setter
@Getter
@EqualsAndHashCode
public class OrderEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade =  CascadeType.ALL, orphanRemoval = true)
    private List<OrderProductEntity> products;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private ShopEntity shop;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
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