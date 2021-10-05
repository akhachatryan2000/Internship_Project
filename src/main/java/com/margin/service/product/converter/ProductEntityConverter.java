package com.margin.service.product.converter;

import com.margin.entity.ProductEntity;
import com.margin.service.product.model.ProductModel;
import org.springframework.stereotype.Component;

@Component
public class ProductEntityConverter {

    public ProductModel convert(ProductEntity productEntity) {
        if (productEntity == null) {
            return null;
        }
        return new ProductModel(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getActive(),
                productEntity.getVisible(),
                productEntity.getPrice(),
                productEntity.getUnit(),
                productEntity.getShopEntity().getId());
    }
}
