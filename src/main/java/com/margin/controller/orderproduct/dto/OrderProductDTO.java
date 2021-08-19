package com.margin.controller.orderproduct.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@EqualsAndHashCode
public class OrderProductDTO {

    private Long id;

    private Long orderId;

    private BigDecimal totalPrice;

    private Long productId;

    private BigDecimal amount;

    private String comment;

    private BigDecimal originalPrice;

    private BigDecimal discount;


}
