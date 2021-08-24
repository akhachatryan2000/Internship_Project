package com.margin.repository.order.entity;

import com.margin.common.enums.PaymentType;
import com.margin.repository.address.entity.AddressEntity;
import com.margin.repository.customer.entity.CustomerEntity;
import com.margin.repository.orderproduct.entity.OrderProductEntity;
import com.margin.repository.shop.entity.ShopEntity;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "OrderEntity")
@Table(name = "orders")
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_product_id")
    private List<OrderProductEntity> products;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "shop_id")
    private ShopEntity shop;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private AddressEntity address;

    @Column(name = "original_price", nullable = false)
    private BigDecimal originalPrice;

    @Column(name = "total_price", nullable = false)
    private BigDecimal totalPrice;

    @Column(name = "paid_from_bonus", nullable = false)
    private BigDecimal paidFromBonus;

    @Column(name = "payment_type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private PaymentType paymentType;

    @Column(name = "order_discount", nullable = false)
    private BigDecimal orderDiscount;
}