package com.margin.repository.product.converter;

import com.margin.controller.product.dto.ProductCreationDTO;
import com.margin.controller.product.dto.ProductDTO;
import com.margin.controller.product.dto.ProductUpdateDTO;
import com.margin.repository.product.entity.ProductCreationEntity;
import com.margin.repository.product.entity.ProductEntity;
import com.margin.repository.product.entity.ProductUpdateEntity;
import com.margin.repository.shop.converter.ShopEntityConverter;
import com.margin.repository.shop.entity.ShopEntity;
import com.margin.service.product.model.ProductCreationModel;
import com.margin.service.product.model.ProductModel;
import com.margin.service.product.model.ProductUpdateModel;
import com.margin.service.shop.model.ShopModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductEntityConverter {

    @Autowired
    private ShopEntityConverter shopEntityConverter;

    public ProductModel convert(ProductEntity productEntity) {
        if (productEntity == null) {
            return null;
        }
        ProductModel productModel = new ProductModel();
        productModel.setId(productEntity.getId());
        productModel.setName(productEntity.getName());
        productModel.setName(productEntity.getName());
        productModel.setActive(productEntity.getActive());
        productModel.setDescription(productEntity.getDescription());
        productModel.setPrice(productEntity.getPrice());
        ShopEntity shopEntity = productEntity.getShopEntity();
        ShopModel shopModel = shopEntityConverter.convert(shopEntity);
        productModel.setShop(shopModel);
        productModel.setVisible(productEntity.getVisible());
        productModel.setUnit(productEntity.getUnit());
        return productModel;
    }

    public ProductCreationModel convert(ProductCreationEntity productEntity) {
        if (productEntity == null) {
            return null;
        }
        ProductCreationModel productModel = new ProductCreationModel();
        productModel.setName(productEntity.getName());
        productModel.setName(productEntity.getName());
        productModel.setActive(productEntity.getActive());
        productModel.setDescription(productEntity.getDescription());
        productModel.setPrice(productEntity.getPrice());
        //productModel.setShop(productEntity.getShop());
        productModel.setVisible(productEntity.getVisible());
        productModel.setUnit(productEntity.getUnit());
        return productModel;


    }

    public ProductUpdateModel convert(ProductUpdateEntity productEntity) {
        if (productEntity == null) {
            return null;
        }
        ProductUpdateModel productModel = new ProductUpdateModel();
        productModel.setId(productEntity.getId());
        productModel.setName(productEntity.getName());
        productModel.setName(productEntity.getName());
        productModel.setActive(productEntity.getActive());
        productModel.setDescription(productEntity.getDescription());
        productModel.setPrice(productEntity.getPrice());
        //productModel.setShop(productEntity.getShop());
        productModel.setVisible(productEntity.getVisible());
        productModel.setUnit(productEntity.getUnit());
        return productModel;

    }


}
