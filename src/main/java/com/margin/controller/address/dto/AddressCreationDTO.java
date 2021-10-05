package com.margin.controller.address.dto;

import com.margin.common.enums.Country;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class AddressCreationDTO {

    @NotNull(message = "must not be null")
    private Country country;

    private String district;

    private String city;

    @NotNull
    @NotBlank
    private String addressLine1;

    private String addressLine2;

    private String postCode;
}
