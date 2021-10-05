package com.margin.service.shop.model;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class ShopCreationModel {

    private String name;

    private Boolean active;

    private Boolean visible;

}
