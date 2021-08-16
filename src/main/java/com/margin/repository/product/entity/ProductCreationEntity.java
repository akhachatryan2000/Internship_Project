package com.margin.repository.product.entity;

import com.margin.common.enums.Unit;
import com.margin.repository.productschedule.ProductScheduleCreationEntity;
import com.margin.repository.shop.entity.ShopCreationEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import java.math.BigDecimal;
@Setter
@Getter
public class ProductCreationEntity {


    private String name;

    private String description;

    private Boolean active;

    private Boolean visible;

    private BigDecimal price;

    private Unit unit;

    //private ProductScheduleCreationEntity productScheduleCreationEntity;

    private ShopCreationEntity shopCreationEntity;

}
