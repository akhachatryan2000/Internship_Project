package com.margin.controller.user.converter;

import com.margin.controller.user.dto.UserCreationDto;
import com.margin.controller.user.dto.UserDto;
import com.margin.controller.user.dto.UserUpdateDto;
import com.margin.service.user.model.UserCreationModel;
import com.margin.service.user.model.UserModel;
import com.margin.service.user.model.UserUpdateModel;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {

    public UserModel convert(UserDto userDto) {
        return new UserModel(
                userDto.getId(),
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getName(),
                userDto.getSurname(),
                userDto.getRole()
        );
    }

    public UserCreationModel convert(UserCreationDto userDto) {
        return new UserCreationModel(
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getName(),
                userDto.getSurname(),
                userDto.getRole());
    }

    public UserUpdateModel convert(UserUpdateDto userUpdateDto) {
        return new UserUpdateModel(
                userUpdateDto.getId(),
                userUpdateDto.getUsername(),
                userUpdateDto.getPassword(),
                userUpdateDto.getName(),
                userUpdateDto.getSurname(),
                userUpdateDto.getRole()
        );
    }
}
