package com.margin.repository.shop.entity;

import com.margin.repository.product.entity.ProductEntity;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity(name = "ShopEntity")
@Table(name = "shops")
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ShopEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name = "active",nullable = false)
    private Boolean active;

    @Column(name = "visible",nullable = false)
    private Boolean visible;

    @OneToMany(mappedBy = "shopEntity", cascade = CascadeType.ALL)
    private List<ProductEntity> productEntities;
}
