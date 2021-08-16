package com.margin.service.product.converter;

import com.margin.controller.product.dto.ProductCreationDTO;
import com.margin.controller.product.dto.ProductDTO;
import com.margin.controller.product.dto.ProductUpdateDTO;
import com.margin.controller.shop.dto.ShopCreationDTO;
import com.margin.controller.shop.dto.ShopDTO;
import com.margin.controller.shop.dto.ShopUpdateDTO;
import com.margin.service.product.model.ProductCreationModel;
import com.margin.service.product.model.ProductModel;
import com.margin.service.product.model.ProductUpdateModel;
import com.margin.service.shop.converter.ShopModelConverter;
import com.margin.service.shop.model.ShopCreationModel;
import com.margin.service.shop.model.ShopModel;
import com.margin.service.shop.model.ShopUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductModelConverter {

    @Autowired
    private ShopModelConverter shopModelConverter;


    public ProductCreationDTO convert(ProductCreationModel productModel) {
        if (productModel==null) {
            return null;
        }
        ProductCreationDTO productDTO= new ProductCreationDTO();
        productDTO.setName(productModel.getName());
        productDTO.setActive(productModel.getActive());
        productDTO.setDescription(productModel.getDescription());
        productDTO.setPrice(productModel.getPrice());
        ShopCreationModel shopCreationModel=productModel.getShop();
        ShopCreationDTO shopCreationDTO=shopModelConverter.convert(shopCreationModel);
        productDTO.setShop(shopCreationDTO);
        productDTO.setVisible(productModel.getVisible());
        productDTO.setUnit(productModel.getUnit());
        return productDTO;
    }

    public ProductDTO convert(ProductModel productModel) {
        if (productModel==null) {
            return null;
        }
       ProductDTO productDTO= new ProductDTO();
       productDTO.setId(productModel.getId());
        productDTO.setName(productModel.getName());
        productDTO.setActive(productModel.getActive());
        productDTO.setDescription(productModel.getDescription());
        productDTO.setPrice(productModel.getPrice());
        ShopModel shopModel=productModel.getShop();
        ShopDTO shopDTO= shopModelConverter.convert(shopModel);
        productDTO.setShop(shopDTO);
        productDTO.setVisible(productModel.getVisible());
        productDTO.setUnit(productModel.getUnit());
        return productDTO;

    }

    public ProductUpdateDTO convert(ProductUpdateModel productModel) {
        if (productModel==null) {
            return null;
        }
        ProductUpdateDTO productDTO= new ProductUpdateDTO();
        productDTO.setName(productModel.getName());
        productDTO.setId(productModel.getId());
        productDTO.setActive(productModel.getActive());
        productDTO.setDescription(productModel.getDescription());
        productDTO.setPrice(productModel.getPrice());
        ShopUpdateModel shopUpdateModel=productModel.getShop();
        ShopUpdateDTO shopUpdateDTO= shopModelConverter.convert(shopUpdateModel);
        productDTO.setShop(shopUpdateDTO);
        productDTO.setVisible(productModel.getVisible());
        productDTO.setUnit(productModel.getUnit());
        return productDTO;

    }
}
