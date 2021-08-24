package com.margin.repository.customer.entity;

import com.margin.repository.address.entity.AddressEntity;
import com.margin.repository.order.entity.OrderEntity;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "CustomerEntity")
@Table(name = "customers")
@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private AddressEntity address;

    @Column(name = "bonus", nullable = false)
    private BigDecimal bonus;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<OrderEntity> orders;
}
