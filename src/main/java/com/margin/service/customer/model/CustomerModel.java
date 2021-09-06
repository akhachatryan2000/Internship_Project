package com.margin.service.customer.model;

import lombok.*;

import java.math.BigDecimal;


@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class CustomerModel {

    private Long id;

    private String name;

    private String phoneNumber;

    private Long addressId;

    private BigDecimal bonus;
}
