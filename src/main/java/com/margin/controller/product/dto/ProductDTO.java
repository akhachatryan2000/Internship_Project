package com.margin.controller.product.dto;

import com.margin.common.enums.Unit;
import com.margin.controller.shop.dto.ShopDTO;
import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class ProductDTO {

    private Long id;

    private String name;

    private String description;

    private Boolean active;

    private Boolean visible;

    private BigDecimal price;

    private Unit unit;

    private Long shopId;
}
