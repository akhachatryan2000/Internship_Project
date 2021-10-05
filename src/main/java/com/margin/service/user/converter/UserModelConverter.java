package com.margin.service.user.converter;

import com.margin.controller.user.dto.UserDto;
import com.margin.entity.UserEntity;
import com.margin.service.user.model.UserCreationModel;
import com.margin.service.user.model.UserModel;
import com.margin.service.user.model.UserUpdateModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserModelConverter {

    public UserDto convert(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        return new UserDto(
                userModel.getId(),
                userModel.getUsername(),
                userModel.getPassword(),
                userModel.getName(),
                userModel.getSurname(),
                userModel.getRole()
        );
    }

    public UserEntity convert(UserCreationModel userCreationModel) {
        if (userCreationModel == null) {
            return null;
        }
        UserEntity user = new UserEntity();
        user.setUsername(userCreationModel.getUsername());
        user.setPassword(userCreationModel.getPassword());
        user.setName(userCreationModel.getName());
        user.setSurname(userCreationModel.getSurname());
        user.setRole(userCreationModel.getRole());
        return user;
    }

    public UserEntity convert(UserUpdateModel userUpdateModel, UserEntity user) {
        if (userUpdateModel == null && user == null) {
            return null;
        }
        user.setUsername(userUpdateModel.getUsername());
        user.setPassword(userUpdateModel.getPassword());
        user.setName(userUpdateModel.getName());
        user.setSurname(userUpdateModel.getSurname());
        user.setRole(userUpdateModel.getRole());
        return user;
    }
}
