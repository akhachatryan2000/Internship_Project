package com.margin.service.order.model;

import com.margin.common.enums.PaymentType;
import com.margin.service.orderproduct.model.OrderProductCreationModel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class OrderCreationModel {

    private List<OrderProductCreationModel> orderProducts;

    private Long customerId;

    private Long shopId;

    private Long addressId;

    private BigDecimal originalPrice;

    private BigDecimal totalPrice;

    private BigDecimal paidFromBonus;

    private PaymentType paymentType;

    private BigDecimal orderDiscount;
}
