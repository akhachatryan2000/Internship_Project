package com.margin.controller.address.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.margin.common.enums.Country;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class AddressDTO {

    @JsonProperty("id")
    private Long id;

    private Country country;

    private String district;

    private String city;

    private String addressLine1;

    private String addressLine2;

    private String postCode;
}
