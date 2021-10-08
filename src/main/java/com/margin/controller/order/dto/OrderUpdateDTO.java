package com.margin.controller.order.dto;

import com.margin.common.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class OrderUpdateDTO {

    private Long id;

    private Long customerId;

    private Long shopId;

    private Long addressId;

    private BigDecimal originalPrice;

    private BigDecimal totalPrice;

    private BigDecimal paidFromBonus;

    private PaymentType paymentType;

    private BigDecimal orderDiscount;
}
