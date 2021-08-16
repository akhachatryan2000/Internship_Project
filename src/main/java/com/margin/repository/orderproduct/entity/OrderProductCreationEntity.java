package com.margin.repository.orderproduct.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Setter
@Getter
public class OrderProductCreationEntity {


    private Long productId;

    private Long orderId;

    private BigDecimal sum;

    private BigDecimal totalPrice;


    private Integer amount;

    private String comment;

    private BigDecimal originalPrice;

    private BigDecimal discount;
}
