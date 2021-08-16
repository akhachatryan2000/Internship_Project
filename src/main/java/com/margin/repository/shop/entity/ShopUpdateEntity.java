package com.margin.repository.shop.entity;

import com.margin.common.Schedule;
import com.margin.repository.product.entity.ProductEntity;
import com.margin.repository.product.entity.ProductUpdateEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class ShopUpdateEntity {

    private Long id;

    private String name;

    private Boolean active;

    private Boolean visible;

    private List<ProductUpdateEntity> productEntities;

    //private User user;

    private Schedule schedule;
}
