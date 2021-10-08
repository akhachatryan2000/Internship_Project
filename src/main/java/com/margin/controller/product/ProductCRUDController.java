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
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(path = "/products")
@AllArgsConstructor
public class ProductCRUDController {

    private ProductService productService;

    private ProductModelConverter productModelConverter;

    private ProductDTOConverter productDTOConverter;

    @GetMapping(path = "/{id}")
    public GenericResponse<ProductDTO> get(@PathVariable(name = "id") Long id) {
        ProductModel productModel = productService.get(id);
        ProductDTO productDTO = productModelConverter.convert(productModel);
        return new GenericResponse<>(productDTO, null);
    }

    @PostMapping("create")
    public GenericResponse<ProductDTO> post(@RequestBody ProductCreationDTO productCreationDTO) {
        ProductCreationModel productCreationModel = productDTOConverter.convert(productCreationDTO);
        ProductModel productModel = productService.create(productCreationModel);
        ProductDTO productDTO = productModelConverter.convert(productModel);
        return new GenericResponse<>(productDTO, null);
    }

    @PutMapping(path = "/{id}/update")
    public GenericResponse<ProductDTO> put(@PathVariable(name = "id") Long id, @RequestBody ProductUpdateDTO productUpdateDTO) {
        ProductUpdateModel productUpdateModel = productDTOConverter.convert(productUpdateDTO);
        ProductModel productModel = productService.update(productUpdateModel, id);
        ProductDTO productDTO = productModelConverter.convert(productModel);
        return new GenericResponse<>(productDTO, null);
    }

    @DeleteMapping(path = "/{id}/delete")
    public GenericResponse<Boolean> delete(@PathVariable(name = "id") Long id) {
        Boolean isDeleted = productService.delete(id);
        return new GenericResponse<>(isDeleted, null);
    }

    @GetMapping
    public GenericResponse<List<ProductDTO>> getAll() {
        List<ProductModel> products = productService.getAll();
        List<ProductDTO> productDTOS = products
                .stream()
                .map(productModel -> productModelConverter
                        .convert(productModel))
                .collect(Collectors.toList());
        return new GenericResponse<>(productDTOS, null);
    }
}
