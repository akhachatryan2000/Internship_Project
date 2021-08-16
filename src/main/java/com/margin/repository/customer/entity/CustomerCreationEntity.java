package com.margin.repository.customer.entity;

import com.margin.controller.address.dto.AddressDTO;
import com.margin.controller.order.dto.OrderDTO;
import com.margin.repository.address.entity.AddressCreationEntity;
import com.margin.repository.order.entity.OrderCreationEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
@Setter
@Getter
public class CustomerCreationEntity {

    private String name;

    private String phoneNumber;

    private AddressCreationEntity address;

    private BigDecimal bonus;

    private List<OrderCreationEntity> orders;
}
