package com.margin.repository.orderproduct.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "OrderProductEntity")
@Table(name = "order_products")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductEntity {
    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn(name = "product_id")
    private Long productId;

    @JoinColumn(name = "order_id")
    private Long orderId;

    @Column(name = "sum")
    private BigDecimal amount;

    @Column(name = "total_Price")
    private BigDecimal totalPrice;

    @Column(name = "comment")
    private String comment;

    @Column(name = "original_Price")
    private BigDecimal originalPrice;

    @Column(name = "discount")
    private BigDecimal discount;
}
