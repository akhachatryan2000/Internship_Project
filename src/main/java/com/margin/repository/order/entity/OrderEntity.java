package com.margin.repository.order.entity;

import com.margin.common.enums.PaymentType;
import com.margin.repository.AbstractEntity;
import com.margin.repository.address.entity.AddressEntity;
import com.margin.repository.customer.entity.CustomerEntity;
import com.margin.repository.orderproduct.entity.OrderProductEntity;
import com.margin.repository.shop.entity.ShopEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "OrderEntity")
@Table(name = "orders")
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_product_id")
    private List< @Valid OrderProductEntity> products;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "shop_id")
    private ShopEntity shop;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "address_id")
    private AddressEntity address;

    @Column(name = "original_price", nullable = false)
    private BigDecimal originalPrice;

    @Column(name = "total_price", nullable = false)
    @Positive(message = "Total price must be positive")
    private BigDecimal totalPrice;

    @Column(name = "paid_from_bonus", nullable = false)
    private BigDecimal paidFromBonus;

    @Column(name = "payment_type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private PaymentType paymentType;

    @Column(name = "order_discount")
    private BigDecimal orderDiscount;

}