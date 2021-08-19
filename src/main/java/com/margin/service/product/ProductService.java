package com.margin.service.product;

import com.margin.repository.product.ProductRepository;
import com.margin.repository.product.entity.ProductEntity;
import com.margin.service.product.converter.ProductEntityConverter;
import com.margin.service.product.model.ProductCreationModel;
import com.margin.service.product.model.ProductModel;
import com.margin.service.product.model.ProductUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductEntityConverter productEntityConverter;


   public ProductModel get(Long id) {
        try {
            ProductEntity productEntity =productRepository.getById(id);
            ProductModel productModel = productEntityConverter.convert(productEntity);
            return productModel;
        } catch (EntityNotFoundException exception) {
            System.out.println("No such element to retrieve");
        }

        return null;
    }

    public ProductModel create(ProductCreationModel productCreationModel) {
        ProductEntity productEntity = productEntityConverter.convert(productCreationModel);
        ProductEntity productCreated = productRepository.save(productEntity);
        ProductModel productModel = productEntityConverter.convert(productCreated);
        return productModel;
    }

    public ProductModel update(ProductUpdateModel productUpdateModel, Long id) {
        try {
            ProductEntity productEntity = productRepository.getById(id);
            ProductEntity orderEntity1 = productEntityConverter.convert(productUpdateModel, productEntity);
            ProductModel productModel = productEntityConverter.convert(orderEntity1);
            return productModel;

        } catch (EntityNotFoundException exception) {
            System.out.println("There is no such entity to update");
        }
        return null;
    }

    public Boolean delete(Long id) {
        try {
            productRepository.deleteById(id);
            return true;

        } catch (EntityNotFoundException exception) {
            System.out.println("No such entity to delete");
        }
        return null;
    }

}
