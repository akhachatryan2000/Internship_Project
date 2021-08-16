package com.margin.repository.address.entity;

import com.margin.common.enums.Country;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressCreationEntity {

    private Country country;

    private String district;

    private String city;

    private String addressLine1;

    private String addressLine2;

    private String postCode;

}
