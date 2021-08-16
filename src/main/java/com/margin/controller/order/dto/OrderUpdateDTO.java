package com.margin.controller.order.dto;

import com.margin.common.enums.PaymentType;
import com.margin.controller.address.dto.AddressDTO;
import com.margin.controller.address.dto.AddressUpdateDTO;
import com.margin.controller.customer.dto.CustomerDTO;
import com.margin.controller.customer.dto.CustomerUpdateDTO;
import com.margin.controller.orderproduct.dto.OrderProductDTO;
import com.margin.controller.orderproduct.dto.OrderProductUpdateDTO;
import com.margin.controller.shop.dto.ShopDTO;
import com.margin.controller.shop.dto.ShopUpdateDTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
@Setter
@Getter
public class OrderUpdateDTO {

    private List<OrderProductUpdateDTO> products;

    private CustomerUpdateDTO customer;

    private ShopUpdateDTO shop;

    private AddressUpdateDTO address;

    private BigDecimal originalPrice;

    private BigDecimal totalPrice;

    private BigDecimal paidFromBonus;

    private PaymentType paymentType;

    private BigDecimal orderDiscount;
}
