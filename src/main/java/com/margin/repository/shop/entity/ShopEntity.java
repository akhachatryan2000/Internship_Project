package com.margin.repository.shop.entity;

import com.margin.repository.AbstractEntity;
import com.margin.repository.product.entity.ProductEntity;
import lombok.*;
import org.intellij.lang.annotations.Pattern;

import javax.persistence.*;
import java.util.List;

@Entity(name = "ShopEntity")
@Table(name = "shops")
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ShopEntity extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "active", nullable = false)
    private Boolean active;

    @Column(name = "visible", nullable = false)
    private Boolean visible;

    @OneToMany(mappedBy = "shopEntity", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<ProductEntity> productEntities;
}
