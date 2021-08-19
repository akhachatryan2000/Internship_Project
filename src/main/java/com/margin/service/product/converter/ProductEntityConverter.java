package com.margin.service.product.converter;

import com.margin.repository.product.entity.ProductEntity;
import com.margin.service.product.model.ProductCreationModel;
import com.margin.service.product.model.ProductModel;
import com.margin.service.product.model.ProductUpdateModel;
import org.springframework.stereotype.Component;

@Component
public class ProductEntityConverter {

    public ProductModel convert(ProductEntity productEntity) {
        if (productEntity == null) {
            return null;
        }

        ProductModel productModel = new ProductModel();
        productModel.setId(productEntity.getId());
        productModel.setName(productEntity.getName());
        productModel.setActive(productEntity.getActive());
        productModel.setPrice(productEntity.getPrice());
        productModel.setDescription(productEntity.getDescription());
        productModel.setUnit(productEntity.getUnit());
        productModel.setVisible(productEntity.getVisible());
        productModel.setShopId(productEntity.getShopEntity().getId());
        return productModel;
    }

    public ProductEntity convert(ProductModel productModel) {
        if (productModel == null) {
            return null;
        }
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(productModel.getId());
        productEntity.setName(productModel.getName());
        productEntity.setActive(productModel.getActive());
        productEntity.setPrice(productEntity.getPrice());
        productEntity.setDescription(productEntity.getDescription());
        productEntity.setVisible(productModel.getVisible());
        //  productEntity.setShopEntity(productModel.getShopId());
        return productEntity;
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
        // productEntity.setShopEntity(productUpdateModel.getShopId());
        productEntity.setActive(productUpdateModel.getActive());
        productEntity.setVisible(productUpdateModel.getVisible());
        productEntity.setPrice(productUpdateModel.getPrice());
        productEntity.setDescription(productUpdateModel.getDescription());
        productEntity.setName(productUpdateModel.getName());
        productEntity.setUnit(productUpdateModel.getUnit());
        return productEntity;
    }
}
