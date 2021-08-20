package com.margin.service.product.converter;

import com.margin.controller.product.dto.ProductCreationDTO;
import com.margin.controller.product.dto.ProductDTO;
import com.margin.controller.product.dto.ProductUpdateDTO;
import com.margin.service.product.model.ProductCreationModel;
import com.margin.service.product.model.ProductModel;
import com.margin.service.product.model.ProductUpdateModel;
import com.margin.service.shop.converter.ShopModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
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
}
