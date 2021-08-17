package com.margin.repository.shop.entity;

import com.margin.common.Schedule;

import com.margin.repository.product.entity.ProductEntity;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;

@Entity(name = "ShopEntity")
@Table(name = "shop")
@Setter
@Getter
public class ShopEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "visible")
    private Boolean visible;

    @OneToMany(mappedBy = "shopEntity", cascade = CascadeType.ALL)
    private List<ProductEntity> productEntities;

   // private user

   // private Schedule schedule;


}
