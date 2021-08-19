package com.margin.service.orderproduct.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Setter
@Getter
public class OrderProductModel {

    private Long id;

    private Long orderId;

    private Long productId;

    private BigDecimal totalPrice;

    private BigDecimal amount;

    private String comment;

    private BigDecimal originalPrice;

    private BigDecimal discount;
}
