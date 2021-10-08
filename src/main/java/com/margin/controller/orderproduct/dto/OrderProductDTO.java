package com.margin.controller.orderproduct.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class OrderProductDTO {

    private Long id;

    private Long orderId;

    private Long productId;

    private BigDecimal totalPrice;

    private BigDecimal amount;

    private String comment;

    private BigDecimal originalPrice;

    private BigDecimal discount;


}
