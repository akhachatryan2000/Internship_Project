package com.margin.repository.shop.entity;

import com.margin.common.Schedule;

import com.margin.repository.product.entity.ProductEntity;
import lombok.*;


import javax.persistence.*;
import java.util.List;

@Entity(name = "ShopEntity")
@Table(name = "shop")
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
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
