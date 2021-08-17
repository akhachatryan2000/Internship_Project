package com.margin.controller.address.dto;

import com.margin.common.enums.Country;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressCreationDTO {

    private Country country;

    private String district;

    private String city;

    private String addressLine1;

    private String addressLine2;

    private String postCode;
}