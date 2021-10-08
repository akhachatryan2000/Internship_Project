package com.margin.entity;

import com.margin.common.enums.Country;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class AddressEntity extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country", nullable = false)
    @Enumerated(EnumType.STRING)
    private Country country;

    @Column(name = "district", nullable = false)
    private String district;

    @Column
    private String city;

    @Column
    private String addressLine1;

    @Column
    private String addressLine2;

    @Column
    private String postCode;

    public AddressEntity() {
        super();
    }
}
