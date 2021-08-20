package com.margin.controller.customer.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class CustomerCreationDTO {

    private String name;

    private String phoneNumber;

    private Long addressId;

    private BigDecimal bonus;
}
