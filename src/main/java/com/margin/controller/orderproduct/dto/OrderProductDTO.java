package com.margin.controller.orderproduct.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class OrderProductDTO {

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
