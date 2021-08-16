package com.margin.repository.shop.entity;

import com.margin.common.Schedule;

import com.margin.repository.product.entity.ProductCreationEntity;
import com.margin.repository.product.entity.ProductEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class ShopCreationEntity {

    private String name;

    private Boolean active;

    private Boolean visible;

    private List<ProductCreationEntity> productEntities;

   // private User user;

    private Schedule schedule;
}
