package com.margin.controller.product;

import com.margin.common.exception.response.GenericResponse;
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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


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
    public GenericResponse<ProductDTO> get(@PathVariable(name = "id") Long id) {
        ProductModel productModel = productService.get(id);
        ProductDTO productDTO = productModelConverter.convert(productModel);
        return new GenericResponse<>(productDTO, null);
    }

    @PostMapping
    public GenericResponse<ProductDTO> post(@Valid @RequestBody ProductCreationDTO productCreationDTO) {
        ProductCreationModel productCreationModel = productDTOConverter.convert(productCreationDTO);
        ProductModel productModel = productService.create(productCreationModel);
        ProductDTO productDTO = productModelConverter.convert(productModel);
        return new GenericResponse<>(productDTO, null);
    }

    @PutMapping(path = "/{id}")
    public GenericResponse<ProductDTO> put(@PathVariable(name = "id") Long id, @Valid @RequestBody ProductUpdateDTO productUpdateDTO) {
        ProductUpdateModel productUpdateModel = productDTOConverter.convert(productUpdateDTO);
        ProductModel productModel = productService.update(productUpdateModel);
        ProductDTO productDTO = productModelConverter.convert(productModel);
        return new GenericResponse<>(productDTO, null);
    }

    @DeleteMapping(path = "/{id}")
    public GenericResponse<Boolean> delete(@PathVariable(name = "id") Long id) {
        Boolean isDeleted = productService.delete(id);
        return new GenericResponse<>(isDeleted, null);
    }
}
