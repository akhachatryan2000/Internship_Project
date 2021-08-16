package com.margin.controller.order.dto;

import com.margin.common.enums.PaymentType;
import com.margin.controller.address.dto.AddressDTO;
import com.margin.controller.customer.dto.CustomerDTO;
import com.margin.controller.orderproduct.dto.OrderProductDTO;
import com.margin.controller.shop.dto.ShopDTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
@Getter
@Setter
public class OrderDTO {

    private List<OrderProductDTO> products;

    private CustomerDTO customer;

    private ShopDTO shop;

    private AddressDTO address;

    private BigDecimal originalPrice;

    private BigDecimal totalPrice;

    private BigDecimal paidFromBonus;

    private PaymentType paymentType;

    private BigDecimal orderDiscount;


}
