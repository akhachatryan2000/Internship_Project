package com.margin.service.shop.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class ShopModel {

    private Long id;

    private String name;

    private Boolean active;

    private Boolean visible;
}
