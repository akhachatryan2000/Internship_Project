package com.margin.service.orderproduct.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Setter
@Getter
public class OrderProductCreationModel {


    private Long productId;

    private Long orderId;

    private BigDecimal sum;

    private BigDecimal totalPrice;


    private Integer amount;

    private String comment;

    private BigDecimal originalPrice;

    private BigDecimal discount;
}
