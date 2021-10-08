package com.margin.controller.shop.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class ShopCreationDTO {

    private String name;

    private Boolean active;

    private Boolean visible;
}
