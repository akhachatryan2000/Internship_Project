package com.margin.controller.orderproduct.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@EqualsAndHashCode
public class OrderProductCreationDTO {

    private Long productId;

    private Long orderId;

    private BigDecimal totalPrice;

    private BigDecimal amount;

    private String comment;

    private BigDecimal originalPrice;

    private BigDecimal discount;
}
