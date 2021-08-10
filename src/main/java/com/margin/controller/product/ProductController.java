package com.margin.controller.product;

import com.margin.service.product.model.ProductModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @GetMapping
    public ResponseEntity<ProductModel> get() {
        return null;
    }

    @PutMapping
    public ResponseEntity<ProductModel> put(int id) {
        return null;
    }

    @DeleteMapping
    public ResponseEntity<Boolean> delete(int id) {
        return null;

    }

    @PostMapping
    public ResponseEntity<ProductModel> post() {
        return null;
    }


}
