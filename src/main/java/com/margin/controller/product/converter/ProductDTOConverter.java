package com.margin.controller.product.converter;


import com.margin.controller.product.dto.ProductCreationDTO;
import com.margin.controller.product.dto.ProductDTO;
import com.margin.controller.product.dto.ProductUpdateDTO;
import com.margin.controller.shop.converter.ShopDTOConverter;
import com.margin.service.product.model.ProductCreationModel;
import com.margin.service.product.model.ProductModel;
import com.margin.service.product.model.ProductUpdateModel;
import com.margin.service.shop.model.ShopCreationModel;
import com.margin.service.shop.model.ShopModel;
import com.margin.service.shop.model.ShopUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDTOConverter {
    @Autowired
    private ShopDTOConverter shopDTOConverter;

    public ProductCreationModel convert(ProductCreationDTO productDTO) {
        if (productDTO == null) {
            return null;
        }
        ProductCreationModel productCreationModel = new ProductCreationModel(
                productDTO.getName(),
                productDTO.getDescription(),
                productDTO.getActive(),
                productDTO.getVisible(),
                productDTO.getPrice(),
                productDTO.getUnit(),
                productDTO.getShopId()

        );

        return productCreationModel;

    }

    public ProductModel convert(ProductDTO productDTO) {
        if (productDTO == null) {
            return null;
        }
        ProductModel productModel = new ProductModel(
                productDTO.getId(),
                productDTO.getName(),
                productDTO.getDescription(),
                productDTO.getActive(),
                productDTO.getVisible(),
                productDTO.getPrice(),
                productDTO.getUnit(),
                productDTO.getShopId()
        );
        return productModel;


    }

    public ProductUpdateModel convert(ProductUpdateDTO productDTO) {
        if (productDTO == null) {
            return null;
        }
        ProductUpdateModel productModel = new ProductUpdateModel(
                productDTO.getId(),
                productDTO.getName(),
                productDTO.getDescription(),
                productDTO.getActive(),
                productDTO.getVisible(),
                productDTO.getPrice(),
                productDTO.getUnit(),
                productDTO.getShopId()
        );

        return productModel;
    }

}
