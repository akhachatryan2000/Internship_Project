package com.margin.entity;

import com.margin.common.enums.Country;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
@Setter
@Getter
@EqualsAndHashCode
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

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "addressLine1", nullable = false)
    private String addressLine1;

    @Column(name = "addressLine2")
    private String addressLine2;

    @Column(name = "post_code")
    private String postCode;

    public AddressEntity() {
        super();
    }
}
