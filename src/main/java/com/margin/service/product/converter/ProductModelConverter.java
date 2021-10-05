package com.margin.service.product.converter;

import com.margin.controller.product.dto.ProductDTO;
import com.margin.entity.ProductEntity;
import com.margin.service.product.model.ProductCreationModel;
import com.margin.service.product.model.ProductModel;
import com.margin.service.product.model.ProductUpdateModel;
import org.springframework.stereotype.Component;

@Component
public class ProductModelConverter {

    public ProductDTO convert(ProductModel productModel) {
        if (productModel == null) {
            return null;
        }
        return new ProductDTO(
                productModel.getId(),
                productModel.getName(),
                productModel.getDescription(),
                productModel.getActive(),
                productModel.getVisible(),
                productModel.getPrice(),
                productModel.getUnit(),
                productModel.getShopId());

    }

    public ProductEntity convert(ProductCreationModel productCreationModel) {
        if (productCreationModel == null) {
            return null;
        }
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(productCreationModel.getName());
        productEntity.setVisible(productCreationModel.getVisible());
        productEntity.setDescription(productCreationModel.getDescription());
        productEntity.setPrice(productCreationModel.getPrice());
        productEntity.setUnit(productCreationModel.getUnit());
        productEntity.setActive(productCreationModel.getActive());
        return productEntity;
    }

    public ProductEntity convert(ProductUpdateModel productUpdateModel, ProductEntity productEntity) {
        if (productUpdateModel == null && productEntity == null) {
            return null;
        }
        productEntity.setActive(productUpdateModel.getActive());
        productEntity.setVisible(productUpdateModel.getVisible());
        productEntity.setPrice(productUpdateModel.getPrice());
        productEntity.setDescription(productUpdateModel.getDescription());
        productEntity.setName(productUpdateModel.getName());
        productEntity.setUnit(productUpdateModel.getUnit());
        return productEntity;
    }
}
