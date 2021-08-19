package com.margin.controller.customer.dto;

import com.margin.controller.address.dto.AddressDTO;
import com.margin.controller.address.dto.AddressUpdateDTO;
import com.margin.controller.order.dto.OrderDTO;
import com.margin.controller.order.dto.OrderUpdateDTO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.criterion.Order;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class CustomerUpdateDTO {

    private Long id;

    private String name;

    private String phoneNumber;

    private Long addressId;

    private BigDecimal bonus;

    private List<Order> orders;
}
