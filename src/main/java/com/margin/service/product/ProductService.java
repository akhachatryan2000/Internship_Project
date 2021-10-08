package com.margin.service.product;

import com.margin.service.product.model.ProductCreationModel;
import com.margin.service.product.model.ProductModel;
import com.margin.service.product.model.ProductUpdateModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    ProductModel get(Long id);

    Boolean delete(Long id);

    ProductModel create(ProductCreationModel productCreationModel);

    ProductModel update(ProductUpdateModel productUpdateModel, Long id);

    List<ProductModel> getAll();
}
