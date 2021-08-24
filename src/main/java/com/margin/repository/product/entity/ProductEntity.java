package com.margin.repository.product.entity;

import com.margin.common.enums.Unit;
import com.margin.repository.shop.entity.ShopEntity;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "ProductEntity")
@Setter
@Getter
@Table(name = "products")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "active", nullable = false)
    private Boolean active;

    @Column(name = "visible", nullable = false)
    private Boolean visible;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "unit", nullable = false)
    @Enumerated(EnumType.STRING)
    private Unit unit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private ShopEntity shopEntity;
}
