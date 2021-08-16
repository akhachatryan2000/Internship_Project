package com.margin.repository.customer.entity;

import com.margin.controller.address.dto.AddressDTO;
import com.margin.controller.order.dto.OrderDTO;
import com.margin.repository.address.entity.AddressUpdateEntity;
import com.margin.repository.order.entity.OrderUpdateEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
@Setter
@Getter
public class CustomerUpdateEntity {

    private Long id;

    private String name;

    private String phoneNumber;

    private AddressUpdateEntity address;

    private BigDecimal bonus;

    private List<OrderUpdateEntity> orders;
}
