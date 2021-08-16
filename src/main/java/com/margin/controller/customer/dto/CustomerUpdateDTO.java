package com.margin.controller.customer.dto;

import com.margin.controller.address.dto.AddressDTO;
import com.margin.controller.address.dto.AddressUpdateDTO;
import com.margin.controller.order.dto.OrderDTO;
import com.margin.controller.order.dto.OrderUpdateDTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
public class CustomerUpdateDTO {

    private Long id;

    private String name;

    private String phoneNumber;

    private AddressUpdateDTO address;

    private BigDecimal bonus;

    private List<OrderUpdateDTO> orders;
}
