package com.margin.controller.order.dto;

import com.margin.common.enums.PaymentType;
import com.margin.controller.address.dto.AddressCreationDTO;
import com.margin.controller.customer.dto.CustomerCreationDTO;
import com.margin.controller.orderproduct.dto.OrderProductCreationDTO;
import com.margin.controller.shop.dto.ShopCreationDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class OrderCreationDTO {


    private List<OrderProductCreationDTO> orderProducts;

    private Long customerId;

    private Long shopId;

    private Long addressId;

    private BigDecimal originalPrice;

    private BigDecimal totalPrice;

    private BigDecimal paidFromBonus;

    private PaymentType paymentType;

    private BigDecimal orderDiscount;
}
