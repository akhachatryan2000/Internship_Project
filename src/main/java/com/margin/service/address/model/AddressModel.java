package com.margin.service.address.model;

import com.margin.common.enums.Country;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AddressModel {
    private Long id;

    private Country country;

    private String district;

    private String city;

    private String addressLine1;

    private String addressLine2;

    private String postCode;

}
