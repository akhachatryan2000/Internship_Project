package com.margin.service.order.model;

import com.margin.common.enums.PaymentType;
import com.margin.service.address.model.AddressModel;
import com.margin.service.address.model.AddressUpdateModel;
import com.margin.service.customer.model.CustomerModel;
import com.margin.service.customer.model.CustomerUpdateModel;
import com.margin.service.orderproduct.model.OrderProductModel;
import com.margin.service.orderproduct.model.OrderProductUpdateModel;
import com.margin.service.shop.model.ShopModel;
import com.margin.service.shop.model.ShopUpdateModel;
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
public class OrderUpdateModel {
    private Long id;

    private List<OrderProductUpdateModel> orderProducts;

    private Long customerId;

    private Long shopId;

    private Long addressId;

    private BigDecimal originalPrice;

    private BigDecimal totalPrice;

    private BigDecimal paidFromBonus;

    private PaymentType paymentType;

    private BigDecimal orderDiscount;
}
