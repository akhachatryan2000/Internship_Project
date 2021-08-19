package com.margin.controller.customer.dto;

import com.margin.controller.address.dto.AddressDTO;
import com.margin.controller.order.dto.OrderDTO;
import lombok.*;
import org.hibernate.criterion.Order;

import java.math.BigDecimal;
import java.util.List;
@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class CustomerDTO {

    private Long id;

    private String name;

    private String phoneNumber;

    private Long addressId;

    private BigDecimal bonus;

    private List<Order> orders;
}
