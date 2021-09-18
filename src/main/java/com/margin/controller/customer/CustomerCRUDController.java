package com.margin.controller.customer;

import com.margin.common.exception.response.GenericResponse;
import com.margin.controller.customer.converter.CustomerDTOConverter;
import com.margin.controller.customer.dto.CustomerCreationDTO;
import com.margin.controller.customer.dto.CustomerDTO;
import com.margin.controller.customer.dto.CustomerUpdateDTO;
import com.margin.service.customer.CustomerService;
import com.margin.service.customer.converter.CustomerModelConverter;
import com.margin.service.customer.model.CustomerCreationModel;
import com.margin.service.customer.model.CustomerModel;
import com.margin.service.customer.model.CustomerUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/customers")
@PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
public class CustomerCRUDController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerModelConverter customerModelConverter;

    @Autowired
    private CustomerDTOConverter customerDTOConverter;

    @GetMapping("/{id}")
    @ResponseBody
    public GenericResponse<CustomerDTO> get(@PathVariable(name = "id") Long id) {
        CustomerModel customerModel = customerService.get(id);
        CustomerDTO customerDTO = customerModelConverter.convert(customerModel);
        return new GenericResponse<>(customerDTO, null);
    }

    @PostMapping
    public GenericResponse<CustomerDTO> post(@Valid @RequestBody CustomerCreationDTO customerCreationDTO) {
        CustomerCreationModel customerCreationModel = customerDTOConverter.convert(customerCreationDTO);
        CustomerModel customerModel = customerService.create(customerCreationModel);
        CustomerDTO customerDTO = customerModelConverter.convert(customerModel);
        return new GenericResponse<>(customerDTO, null);
    }

    @PutMapping("/{id}")
    public GenericResponse<CustomerDTO> put(@Valid @RequestBody @NotNull CustomerUpdateDTO customerUpdateDTO, @PathVariable(name = "id") Long id) {
        CustomerUpdateModel customerUpdateModel = customerDTOConverter.convert(customerUpdateDTO);
        CustomerModel customerModel = customerService.update(customerUpdateModel, id);
        CustomerDTO customerDTO = customerModelConverter.convert(customerModel);
        return new GenericResponse<>(customerDTO, null);
    }

    @DeleteMapping("/{id}")
    public GenericResponse<Boolean> delete(@PathVariable(name = "id") Long id) {
        Boolean isDeleted = customerService.delete(id);
        return new GenericResponse<>(isDeleted, null);
    }
}
