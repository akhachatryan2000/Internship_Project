package com.margin.controller.orderproduct.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class OrderProductCreationDTO {

    private Long productId;
    private Long orderId;

    private BigDecimal sum;

    private BigDecimal totalPrice;

    private Integer amount;

    private String comment;

    private BigDecimal originalPrice;

    private BigDecimal discount;
}
