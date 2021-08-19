package com.margin.controller.address;

import com.margin.common.GenericResponseDTO;
import com.margin.controller.address.converter.AddressDTOConverter;
import com.margin.controller.address.dto.AddressCreationDTO;
import com.margin.controller.address.dto.AddressDTO;
import com.margin.controller.address.dto.AddressUpdateDTO;
import com.margin.service.address.AddressService;
import com.margin.service.address.converter.AddressModelConverter;
import com.margin.service.address.model.AddressCreationModel;
import com.margin.service.address.model.AddressModel;
import com.margin.service.address.model.AddressUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/addresses")
public class AddressCRUDController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private AddressDTOConverter addressDTOConverter;

    @Autowired
    private AddressModelConverter addressModelConverter;


    @GetMapping(path = "/{id}")
    @ResponseBody
    public GenericResponseDTO<AddressDTO> get(@PathVariable(name = "id") Long id) {
        AddressModel addressModel = addressService.get(id);
        // TODO return new GenericResponseDTO<AddressModel>(HttpStatus.OK);
        AddressDTO addressDTO = addressModelConverter.convert(addressModel);
        // GenericResponseDTO<AddressDTO> addressDTOGenericResponseDTO = new GenericResponseDTO<AddressDTO>(addressDTO,);
        // return addressDTOGenericResponseDTO;
        return null;
    }

    @PostMapping
    public GenericResponseDTO<AddressDTO> post(@RequestBody AddressCreationDTO addressCreationDTO) {
        AddressCreationModel addressCreationalModel = addressDTOConverter.convert(addressCreationDTO);
        AddressModel addressModel = addressService.create(addressCreationalModel);
        AddressDTO addressDTO = addressModelConverter.convert(addressModel);
        // TODO: 18.08.21 Genereic response creation here
        return null;
    }

    @PutMapping(path = "/{id}")
    public GenericResponseDTO<AddressDTO> put(@PathVariable(name = "id") Long id, @RequestBody AddressUpdateDTO addressUpdateDTO) {
        AddressUpdateModel addressUpdateModel = addressDTOConverter.convert(addressUpdateDTO);
        AddressModel addressModel = addressService.update(addressUpdateModel, id);
        AddressDTO addressDTO = addressModelConverter.convert(addressModel);
        // TODO: 18.08.21 Genereic response creation here
        return null;
    }

    @DeleteMapping(path = "/{id}")
    public GenericResponseDTO<Boolean> delete(@PathVariable(name = "id") Long id) {
        Boolean isDeleted = addressService.delete(id);
        // TODO: 18.08.21 Genereic response creation here
        return null;
    }


}
