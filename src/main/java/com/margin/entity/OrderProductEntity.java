package com.margin.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_products")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductEntity extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "order_id", nullable = false)
    private Long orderId;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "total_Price", nullable = false)
    private BigDecimal totalPrice;

    @Column(name = "comment", nullable = true)
    private String comment;

    @Column(name = "original_Price", nullable = false)
    private BigDecimal originalPrice;

    @Column(name = "discount", nullable = false)
    private BigDecimal discount;
}
