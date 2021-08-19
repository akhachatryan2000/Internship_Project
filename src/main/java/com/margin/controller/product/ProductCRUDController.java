package com.margin.controller.product;

import com.margin.controller.product.converter.ProductDTOConverter;
import com.margin.controller.product.dto.ProductCreationDTO;
import com.margin.controller.product.dto.ProductDTO;
import com.margin.controller.product.dto.ProductUpdateDTO;
import com.margin.service.product.ProductService;
import com.margin.service.product.converter.ProductModelConverter;
import com.margin.service.product.model.ProductCreationModel;
import com.margin.service.product.model.ProductModel;
import com.margin.service.product.model.ProductUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static io.github.benas.randombeans.api.EnhancedRandom.random;

@RestController
@RequestMapping(path = "/products")
public class ProductCRUDController {
    @Autowired
    private ProductService productService;


    @Autowired
    private ProductModelConverter productModelConverter;

    @Autowired
    private ProductDTOConverter productDTOConverter;

    @GetMapping(path = "/{id}")
    @ResponseBody
    public ResponseEntity<ProductModel> get(@PathVariable(name = "id") Long id) {
        ProductModel productModel = productService.get(id);
        ProductDTO productDTO = productModelConverter.convert(productModel);
        return new ResponseEntity<>(random(ProductModel.class), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductModel> post(@RequestBody ProductCreationDTO productCreationDTO) {
        ProductCreationModel productCreationModel = productDTOConverter.convert(productCreationDTO);
        ProductModel productModel = productService.create(productCreationModel);
        ProductDTO productDTO = productModelConverter.convert(productModel);
        if (true) {
            throw new RuntimeException("Anhaskanali ban");

        } else {
            return new ResponseEntity<>(random(ProductModel.class), HttpStatus.OK);
            // TODO: 18.08.21
        }

    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ProductModel> put(@PathVariable(name = "id") Long id, @RequestBody ProductUpdateDTO productUpdateDTO) {
        ProductUpdateModel productUpdateModel = productDTOConverter.convert(productUpdateDTO);
        ProductModel productModel = productService.update(productUpdateModel, id);
        ProductDTO productDTO = productModelConverter.convert(productModel);
        return new ResponseEntity<>(random(ProductModel.class), HttpStatus.OK);
        // TODO: 18.08.21
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(name = "id") Long id) {
        Boolean isDeleted = productService.delete(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
        // TODO: 18.08.21
    }


}
