package com.margin.repository.customer.entity;

import com.margin.repository.AbstractEntity;
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
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "address_id")
    private AddressEntity address;

    @Column(name = "bonus", nullable = false)
    private BigDecimal bonus;

    @OneToMany(mappedBy = "customer", orphanRemoval = true)
    private List<OrderEntity> orders;

}
