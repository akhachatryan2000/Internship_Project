package com.margin.controller.customer.dto;

import com.margin.controller.address.dto.AddressCreationDTO;
import com.margin.controller.address.dto.AddressDTO;
import com.margin.controller.order.dto.OrderCreationDTO;
import com.margin.controller.order.dto.OrderDTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
public class CustomerCreationDTO {

//    private Long id;

    private String name;

    private String phoneNumber;

    private AddressCreationDTO address;

    private BigDecimal bonus;

    private List<OrderCreationDTO> orders;
}
