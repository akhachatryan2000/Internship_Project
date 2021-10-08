package com.margin.controller.user;

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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserCRUDController {

    private UserService userService;

    private UserDtoConverter userDtoConverter;

    private UserModelConverter userModelConverter;


    @GetMapping("/{id}")
    public GenericResponse<UserDto> get(@PathVariable(name = "id") Long id) {
        UserModel userModel = userService.get(id);
        UserDto userDto = userModelConverter.convert(userModel);
        return new GenericResponse<>(userDto, null);
    }

    @GetMapping
    public GenericResponse<List<UserDto>> getAllUsers() {
        List<UserModel> userModels = userService.getAllUsers();
        List<UserDto> userDtos = userModels.stream()
                .map(userModel -> userModelConverter.convert(userModel)).collect(Collectors.toList());
        return new GenericResponse<>(userDtos, null);
    }

    @PostMapping("/create")
    public GenericResponse<UserDto> createUser(@RequestBody UserCreationDto userCreationDto) {
        UserCreationModel userCreationModel = userDtoConverter.convert(userCreationDto);
        UserModel userModel = userService.create(userCreationModel);
        UserDto userDto = userModelConverter.convert(userModel);
        return new GenericResponse<>(userDto, null);
    }

    @PutMapping("/{id}/update")
    public GenericResponse<UserDto> updateUser(@RequestBody UserUpdateDto userUpdateDto, @PathVariable(name = "id") Long id) {
        UserUpdateModel userUpdateModel = userDtoConverter.convert(userUpdateDto);
        UserModel userModel = userService.update(userUpdateModel, id);
        UserDto userDto = userModelConverter.convert(userModel);
        return new GenericResponse<>(userDto, null);
    }

    @DeleteMapping("/{id}/delete")
    public GenericResponse<Boolean> deleteUser(@PathVariable(name = "id") Long id) {
        userService.delete(id);
        return new GenericResponse<>(true, null);
    }
}
