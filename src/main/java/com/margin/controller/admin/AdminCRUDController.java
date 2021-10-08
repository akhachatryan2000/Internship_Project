package com.margin.controller.admin;

import com.margin.common.exception.response.GenericResponse;
import com.margin.controller.user.converter.UserDtoConverter;
import com.margin.controller.user.dto.UserCreationDto;
import com.margin.controller.user.dto.UserDto;
import com.margin.controller.user.dto.UserUpdateDto;
import com.margin.service.user.UserService;
import com.margin.service.user.converter.UserModelConverter;
import com.margin.service.user.model.UserCreationModel;
import com.margin.service.user.model.UserModel;
import com.margin.service.user.model.UserUpdateModel;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admins")
@AllArgsConstructor
public class AdminCRUDController {

    private UserService userService;
    private UserDtoConverter userDtoConverter;
    private UserModelConverter userModelConverter;


    @GetMapping("/{id}")
    public GenericResponse<UserDto> get(@PathVariable(name = "id") Long id) {
        UserModel userModel = userService.get(id);
        UserDto userDto = userModelConverter.convert(userModel);
        return new GenericResponse<>(userDto, null);
    }

    @GetMapping("/users")
    public GenericResponse<List<UserDto>> getAllUsers() {
        List<UserModel> userModels = userService.getAllUsers();
        List<UserDto> userDtos = userModels.stream()
                .map(userModel -> userModelConverter.convert(userModel)).collect(Collectors.toList());
        return new GenericResponse<>(userDtos, null);
    }

    @PostMapping("/user")
    public GenericResponse<UserDto> createUser(@RequestBody @Valid UserCreationDto userCreationDto) {
        UserCreationModel userCreationModel = userDtoConverter.convert(userCreationDto);
        UserModel userModel = userService.create(userCreationModel);
        UserDto userDto = userModelConverter.convert(userModel);
        return new GenericResponse<>(userDto, null);
    }

    @PutMapping("/users/{id}")
    public GenericResponse<UserDto> updateUser(@RequestBody @Valid UserUpdateDto userUpdateDto, @PathVariable(name = "id") Long id) {
        UserUpdateModel userUpdateModel = userDtoConverter.convert(userUpdateDto);
        UserModel userModel = userService.update(userUpdateModel, id);
        UserDto userDto = userModelConverter.convert(userModel);
        return new GenericResponse<>(userDto, null);
    }

    @DeleteMapping("/users/{id}")
    public GenericResponse<Boolean> deleteUser(@PathVariable(name = "id") Long id) {
        userService.delete(id);
        return new GenericResponse<>(true, null);
    }

}
