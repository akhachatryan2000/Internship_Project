package com.margin.service.customer.model;

import com.margin.service.address.model.AddressModel;
import com.margin.service.address.model.AddressUpdateModel;
import com.margin.service.order.model.OrderModel;
import com.margin.service.order.model.OrderUpdateModel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
public class CustomerUpdateModel {

    private Long id;

    private String name;

    private String phoneNumber;

    private Long addressId;

    private BigDecimal bonus;

    private List<OrderModel> orders;
}
