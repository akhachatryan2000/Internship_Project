package com.margin.repository.product.entity;

import com.margin.common.enums.Unit;
import com.margin.repository.productschedule.ProductScheduleEntity;
import com.margin.repository.shop.entity.ShopEntity;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Setter
@Getter
@Table(name = "product")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "active")
    private Boolean active;


    @Column(name = "visible")
    private Boolean visible;


    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "unit")
    private Unit unit;

   // private ProductScheduleEntity schedule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private ShopEntity shopEntity;


}
