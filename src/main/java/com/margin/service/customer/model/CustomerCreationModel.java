package com.margin.service.customer.model;

import com.margin.service.address.model.AddressCreationModel;
import com.margin.service.address.model.AddressModel;
import com.margin.service.order.model.OrderCreationModel;
import com.margin.service.order.model.OrderModel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
public class CustomerCreationModel {


    private String name;

    private String phoneNumber;

    private AddressCreationModel addressModel;

    private BigDecimal bonus;

    private List<OrderCreationModel> orders;
}
