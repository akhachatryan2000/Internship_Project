package com.margin.controller.product.dto;

import com.margin.common.enums.Unit;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class ProductCreationDTO {

    @NotBlank(message = "Product name can not be null")
    private String name;

    @NotNull(message = "Product description can not be null")
    private String description;

    private Boolean active;

    private Boolean visible;

    @NotNull(message = "Product price can not be null")
    @PositiveOrZero(message = "Product price must be positive")
    private BigDecimal price;

    @NotNull(message = "Product unit can not be null")
    private Unit unit;

    @NotNull(message = "Shop id can not be null")
    private Long shopId;
}
