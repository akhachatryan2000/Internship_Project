package com.margin.repository.address.entity;

import com.margin.common.enums.Country;
import lombok.*;

import javax.persistence.*;

@Entity(name = "AddressEntity")
@Table(name = "addresses")
@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "country", nullable = false)
    @Enumerated(EnumType.STRING)
    private Country country;

    @Column(name = "district", nullable = false)
    private String district;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "addressLine1", nullable = false)
    private String addressLine1;

    @Column(name = "addressLine2", nullable = true)
    private String addressLine2;

    @Column(name = "postCode", nullable = false)
    private String postCode;
}
