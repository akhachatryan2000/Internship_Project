package com.margin.repository.orderproduct.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "OrderProductEntity")
@Table(name = "order_product_entity")
@Getter
@Setter
public class OrderProductEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "sum")
    private BigDecimal sum;

    @Column(name = "total_Price")
    private BigDecimal totalPrice;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "comment")
    private String comment;

    @Column(name = "original_Price")
    private BigDecimal originalPrice;

    @Column(name = "discount")
    private BigDecimal discount;
}
