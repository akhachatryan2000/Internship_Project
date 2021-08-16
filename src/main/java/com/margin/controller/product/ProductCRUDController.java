package com.margin.controller.product;

import com.margin.service.product.model.ProductModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static io.github.benas.randombeans.api.EnhancedRandom.random;

@RestController
@RequestMapping(path = "products")
public class ProductCRUDController {

    @GetMapping(path = "{id}")
    public ResponseEntity<ProductModel> get(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(random(ProductModel.class), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductModel> post() {
        if(true) {
            throw new RuntimeException("Anhaskanali ban");

        }else {
            return new ResponseEntity<>(random(ProductModel.class), HttpStatus.OK);
        }

    }

    @PutMapping(path = "{id}")
    public ResponseEntity<ProductModel> put(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(random(ProductModel.class), HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(true, HttpStatus.OK);

    }



}
