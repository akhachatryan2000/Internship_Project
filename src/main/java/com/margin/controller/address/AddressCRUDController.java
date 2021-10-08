package com.margin.controller.address;

import com.margin.common.exception.response.GenericResponse;
import com.margin.controller.address.converter.AddressDTOConverter;
import com.margin.controller.address.dto.AddressCreationDTO;
import com.margin.controller.address.dto.AddressDTO;
import com.margin.controller.address.dto.AddressUpdateDTO;
import com.margin.service.address.AddressService;
import com.margin.service.address.converter.AddressModelConverter;
import com.margin.service.address.model.AddressCreationModel;
import com.margin.service.address.model.AddressModel;
import com.margin.service.address.model.AddressUpdateModel;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/addresses")
@AllArgsConstructor
public class AddressCRUDController {


    private AddressService addressService;

    private AddressDTOConverter addressDTOConverter;

    private AddressModelConverter addressModelConverter;

    @GetMapping(path = "/{id}")
    public GenericResponse<AddressDTO> get(@PathVariable(name = "id") Long id) {
        AddressModel addressModel = addressService.get(id);
        AddressDTO addressDTO = addressModelConverter.convert(addressModel);
        return new GenericResponse<>(addressDTO, null);
    }

    @PostMapping("create")
    public GenericResponse<AddressDTO> post(@RequestBody AddressCreationDTO addressCreationDTO) {
        AddressCreationModel addressCreationModel = addressDTOConverter.convert(addressCreationDTO);
        AddressModel addressModel = addressService.create(addressCreationModel);
        AddressDTO addressDTO = addressModelConverter.convert(addressModel);
        return new GenericResponse<>(addressDTO, null);
    }

    @PutMapping(path = "/{id}/update")
    public GenericResponse<AddressDTO> put(@PathVariable(name = "id") Long id, @RequestBody AddressUpdateDTO addressUpdateDTO) {
        AddressUpdateModel addressUpdateModel = addressDTOConverter.convert(addressUpdateDTO);
        AddressModel addressModel = addressService.update(addressUpdateModel, id);
        AddressDTO addressDTO = addressModelConverter.convert(addressModel);
        return new GenericResponse<>(addressDTO, null);
    }

    @DeleteMapping(path = "/{id}/delete")
    public GenericResponse<Boolean> delete(@PathVariable(name = "id") Long id) {
        Boolean isDeleted = addressService.delete(id);
        return new GenericResponse<>(isDeleted, null);
    }

    @GetMapping
    public GenericResponse<List<AddressDTO>> getAll() {
        List<AddressModel> addresses = addressService.getAll();
        List<AddressDTO> addressDTOS = addresses
                .stream()
                .map(addressModel ->
                        addressModelConverter.convert(addressModel))
                .collect(Collectors.toList());
        return new GenericResponse<>(addressDTOS, null);
    }
}
