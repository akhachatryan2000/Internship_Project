package com.margin.controller.product;

import com.margin.common.GenericResponseDTO;
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
    public GenericResponseDTO<ProductDTO> get(@PathVariable(name = "id") Long id) {
        ProductModel productModel = productService.get(id);
        ProductDTO productDTO = productModelConverter.convert(productModel);
        return new GenericResponseDTO<>(productDTO, null);
    }

    @PostMapping
    public GenericResponseDTO<ProductDTO> post(@RequestBody ProductCreationDTO productCreationDTO) {
        ProductCreationModel productCreationModel = productDTOConverter.convert(productCreationDTO);
        ProductModel productModel = productService.create(productCreationModel);
        ProductDTO productDTO = productModelConverter.convert(productModel);
        return new GenericResponseDTO<>(productDTO, null);
    }

    @PutMapping(path = "/{id}")
    public GenericResponseDTO<ProductDTO> put(@PathVariable(name = "id") Long id, @RequestBody ProductUpdateDTO productUpdateDTO) {
        ProductUpdateModel productUpdateModel = productDTOConverter.convert(productUpdateDTO);
        ProductModel productModel = productService.update(productUpdateModel, id);
        ProductDTO productDTO = productModelConverter.convert(productModel);
        return new GenericResponseDTO<>(productDTO, null);
    }

    @DeleteMapping(path = "/{id}")
    public GenericResponseDTO<Boolean> delete(@PathVariable(name = "id") Long id) {
        Boolean isDeleted = productService.delete(id);
        return new GenericResponseDTO<>(isDeleted, null);
    }
}
