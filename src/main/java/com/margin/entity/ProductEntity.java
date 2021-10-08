package com.margin.entity;

import com.margin.common.enums.Unit;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Setter
@Getter
@Table(name = "products")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
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

    @ManyToOne(optional = false)
    @JoinColumn(name = "shop_id")
    private ShopEntity shopEntity;

}
