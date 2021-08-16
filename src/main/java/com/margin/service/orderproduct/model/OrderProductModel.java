package com.margin.service.orderproduct.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Setter
@Getter
public class OrderProductModel {

    private Long id;

    private Long orderId;

    private BigDecimal sum;

    private BigDecimal totalPrice;

    private Long productId;

    private Integer amount;

    private String comment;

    private BigDecimal originalPrice;

    private BigDecimal discount;
}
