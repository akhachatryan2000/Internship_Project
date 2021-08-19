package com.margin.repository.address.entity;

import com.margin.common.enums.Country;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "AddressEntity")
@Table(name = "address")
@Setter
@Getter
@EqualsAndHashCode
public class AddressEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "country")
    private Country country;

    @Column(name = "district")
    private String district;

    @Column(name = "city")
    private String city;

    @Column(name = "addressLine1")
    private String addressLine1;

    @Column(name = "addressLine2")
    private String addressLine2;

    @Column(name = "postCode")
    private String postCode;


}
