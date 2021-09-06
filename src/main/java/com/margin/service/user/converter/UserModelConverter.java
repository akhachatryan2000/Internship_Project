package com.margin.service.user.converter;

import com.margin.controller.user.dto.UserDto;
import com.margin.repository.user.entity.UserEntity;
import com.margin.service.user.model.UserCreationModel;
import com.margin.service.user.model.UserModel;
import com.margin.service.user.model.UserUpdateModel;
import org.springframework.stereotype.Component;

@Component
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
                userModel.getStatus(),
                null // set roles
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
        // user.setRoleEntities(userCreationModel.getRoleModels());
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
        //user.setRoleEntities(userUpdateModel.getRoleModels());
        return user;
    }
}
