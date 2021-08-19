package com.margin.service.orderproduct.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Setter
@Getter
public class OrderProductCreationModel {


    private Long orderId;

    private Long productId;

    private BigDecimal sum;

    private BigDecimal totalPrice;

    private BigDecimal amount;

    private String comment;

    private BigDecimal originalPrice;

    private BigDecimal discount;
}
