package com.margin.service.product.model;


import com.margin.common.enums.Unit;
import com.margin.service.shop.model.ShopModel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductModel {

    private Long id;

    private String name;

    private String description;

    private Boolean active;

    private Boolean visible;

    private BigDecimal price;

    private Unit unit;

    private Long shopId;






}
