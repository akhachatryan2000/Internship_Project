package com.margin.repository.customer.entity;

import com.margin.controller.address.dto.AddressDTO;
import com.margin.controller.order.dto.OrderDTO;
import com.margin.repository.address.entity.AddressEntity;
import com.margin.repository.order.entity.OrderEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "CustomerEntity")
@Table(name = "customer_entity")
@Setter
@Getter
public class CustomerEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "address")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="customer_id")
    private AddressEntity address;

    @Column(name = "bonus")
    private BigDecimal bonus;

    @Column(name = "orders")
    @OneToMany (cascade = CascadeType.ALL)
    private List<OrderEntity> orders;
}
