package com.margin.repository.customer.entity;

import com.margin.controller.address.dto.AddressDTO;
import com.margin.controller.order.dto.OrderDTO;
import com.margin.repository.address.entity.AddressEntity;
import com.margin.repository.order.entity.OrderEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "CustomerEntity")
@Table(name = "customer")
@Setter
@Getter
@EqualsAndHashCode
public class CustomerEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name="address_id")
    private AddressEntity address;

    @Column(name = "bonus")
    private BigDecimal bonus;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "customer")
    private List<OrderEntity> orders;
}
