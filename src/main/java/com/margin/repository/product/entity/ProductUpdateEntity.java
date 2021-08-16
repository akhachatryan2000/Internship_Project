package com.margin.repository.product.entity;

import com.margin.common.enums.Unit;
import com.margin.repository.productschedule.ProductScheduleUpdateEntity;
import com.margin.repository.shop.entity.ShopUpdateEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import java.math.BigDecimal;
@Setter
@Getter
public class ProductUpdateEntity {
    @Id
    private Long id;

    private String name;

    private String description;

    private Boolean active;

    private Boolean visible;

    private BigDecimal price;

    private Unit unit;

    //private ProductScheduleUpdateEntity scheduleUpdateEntity;

    private ShopUpdateEntity updateEntity;

}
