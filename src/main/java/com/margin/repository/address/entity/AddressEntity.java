package com.margin.repository.address.entity;

import com.margin.common.enums.Country;
import com.margin.repository.AbstractEntity;
import com.margin.repository.address.AddressRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity(name = "AddressEntity")
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
