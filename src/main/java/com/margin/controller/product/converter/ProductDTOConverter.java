package com.margin.controller.product.converter;

import com.margin.controller.product.dto.ProductCreationDTO;
import com.margin.controller.product.dto.ProductDTO;
import com.margin.controller.product.dto.ProductUpdateDTO;
import com.margin.service.product.model.ProductCreationModel;
import com.margin.service.product.model.ProductModel;
import com.margin.service.product.model.ProductUpdateModel;
import org.springframework.stereotype.Component;

@Component
public class ProductDTOConverter {

    public ProductCreationModel convert(ProductCreationDTO productDTO) {
        if (productDTO == null) {
            return null;
        }
        return new ProductCreationModel(
                productDTO.getName(),
                productDTO.getDescription(),
                productDTO.getActive(),
                productDTO.getVisible(),
                productDTO.getPrice(),
                productDTO.getUnit(),
                productDTO.getShopId());
    }

    public ProductModel convert(ProductDTO productDTO) {
        if (productDTO == null) {
            return null;
        }
        return new ProductModel(
                productDTO.getId(),
                productDTO.getName(),
                productDTO.getDescription(),
                productDTO.getActive(),
                productDTO.getVisible(),
                productDTO.getPrice(),
                productDTO.getUnit(),
                productDTO.getShopId());
    }

    public ProductUpdateModel convert(ProductUpdateDTO productDTO) {
        if (productDTO == null) {
            return null;
        }
        return new ProductUpdateModel(
                productDTO.getId(),
                productDTO.getName(),
                productDTO.getDescription(),
                productDTO.getActive(),
                productDTO.getVisible(),
                productDTO.getPrice(),
                productDTO.getUnit(),
                productDTO.getShopId());
    }
}
