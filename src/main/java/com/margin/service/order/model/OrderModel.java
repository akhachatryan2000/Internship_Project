package com.margin.service.order.model;

import com.margin.common.enums.PaymentType;
import com.margin.service.orderproduct.model.OrderProductModel;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class OrderModel {

    private Long id;

    private List<OrderProductModel> orderProducts;

    private Long customerId;

    private Long shopId;

    private Long addressId;

    private BigDecimal originalPrice;

    private BigDecimal totalPrice;

    private BigDecimal paidFromBonus;

    private PaymentType paymentType;

    private BigDecimal orderDiscount;
}
