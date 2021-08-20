package com.margin.service.product.converter;

import com.margin.repository.product.entity.ProductEntity;
import com.margin.repository.shop.entity.ShopRepository;
import com.margin.service.product.model.ProductCreationModel;
import com.margin.service.product.model.ProductModel;
import com.margin.service.product.model.ProductUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
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
        if (productUpdateModel == null) {
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