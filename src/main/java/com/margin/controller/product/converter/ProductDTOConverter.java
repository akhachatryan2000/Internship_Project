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

    public ProductCreationModel convert(ProductCreationDTO productCreationDTO) {
        if (productCreationDTO == null) {
            return null;
        }
        ProductCreationModel productCreationModel = new ProductCreationModel();
        productCreationModel.setName(productCreationDTO.getName());
        productCreationModel.setActive(productCreationDTO.getActive());
        productCreationModel.setDescription(productCreationDTO.getDescription());
        productCreationModel.setPrice(productCreationDTO.getPrice());
        ShopCreationModel shopModel = shopDTOConverter.convert(productCreationDTO.getShop());
        productCreationModel.setShop(shopModel);
        productCreationModel.setVisible(productCreationDTO.getVisible());
        productCreationModel.setUnit(productCreationDTO.getUnit());
        return productCreationModel;

    }

    public ProductModel convert(ProductDTO productDTO) {
        if (productDTO == null) {
            return null;
        }
        ProductModel productModel = new ProductModel();
        productModel.setId(productDTO.getId());
        productModel.setName(productDTO.getName());
        productModel.setName(productDTO.getName());
        productModel.setActive(productDTO.getActive());
        productModel.setDescription(productDTO.getDescription());
        productModel.setPrice(productDTO.getPrice());
        ShopModel shopModel = shopDTOConverter.convert(productDTO.getShop());
        productModel.setShop(shopModel);
        productModel.setVisible(productDTO.getVisible());
        productModel.setUnit(productDTO.getUnit());
        return productModel;


    }

    public ProductUpdateModel convert(ProductUpdateDTO productDTO) {
        if (productDTO == null) {
            return null;
        }
        ProductUpdateModel productModel = new ProductUpdateModel();
        productModel.setId(productDTO.getId());
        productModel.setName(productDTO.getName());
        productModel.setName(productDTO.getName());
        productModel.setActive(productDTO.getActive());
        productModel.setDescription(productDTO.getDescription());
        productModel.setPrice(productDTO.getPrice());
        ShopUpdateModel shopUpdateModel = shopDTOConverter.convert(productDTO.getShop());
        productModel.setShop(shopUpdateModel);
        productModel.setVisible(productDTO.getVisible());
        productModel.setUnit(productDTO.getUnit());
        return productModel;
    }

}
