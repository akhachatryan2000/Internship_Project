package com.margin.controller.product.dto;

import com.margin.common.enums.Unit;
import com.margin.controller.shop.dto.ShopCreationDTO;
import com.margin.controller.shop.dto.ShopDTO;
import com.margin.service.shop.model.ShopCreationModel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Setter
@Getter
public class ProductCreationDTO {


    private String name;

    private String description;

    private Boolean active;

    private Boolean visible;

    private BigDecimal price;

    private Unit unit;

    private ShopCreationDTO shop;
}
