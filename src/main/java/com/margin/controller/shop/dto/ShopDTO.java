package com.margin.controller.shop.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class ShopDTO {

    private Long id;

    private String name;

    private Boolean active;

    private Boolean visible;
}
