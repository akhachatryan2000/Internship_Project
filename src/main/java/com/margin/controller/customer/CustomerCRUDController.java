package com.margin.controller.customer;

import com.margin.common.GenericResponseDTO;
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
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerCRUDController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerModelConverter customerModelConverter;

    @Autowired
    private CustomerDTOConverter customerDTOConverter;

    @GetMapping("/{id}")
    @ResponseBody
    public GenericResponseDTO<CustomerDTO> get(@PathVariable(name = "id") Long id) {
        CustomerModel customerModel = customerService.get(id);
        CustomerDTO customerDTO = customerModelConverter.convert(customerModel);
        // TODO: 18.08.21 Generic response creation here
        return null;
    }

    @PostMapping
    public GenericResponseDTO<CustomerDTO> post(@RequestBody CustomerCreationDTO customerCreationDTO) {
        CustomerCreationModel customerCreationModel = customerDTOConverter.convert(customerCreationDTO);
        CustomerModel customerModel = customerService.create(customerCreationModel);
        CustomerDTO customerDTO = customerModelConverter.convert(customerModel);
        // TODO: 18.08.21 Generic response creation here
        return null;
    }

    @PutMapping("/{id}")
    public GenericResponseDTO<CustomerDTO> put(@RequestBody CustomerUpdateDTO customerUpdateDTO, @PathVariable(name = "id") Long id) {
        CustomerUpdateModel customerUpdateModel = customerDTOConverter.convert(customerUpdateDTO);
        CustomerModel customerModel = customerService.update(customerUpdateModel, id);
        CustomerDTO customerDTO = customerModelConverter.convert(customerModel);
        // TODO: 18.08.21 Generic response creation here
        return null;
    }

    @DeleteMapping("/{id}")
    public GenericResponseDTO<Boolean> delete(@PathVariable(name = "id") Long id) {
        Boolean isDeleted = customerService.delete(id);
        // TODO: 18.08.21 Generic response creation here
        return null;
    }
}
