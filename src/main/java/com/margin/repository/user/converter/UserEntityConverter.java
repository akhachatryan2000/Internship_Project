package com.margin.repository.user.converter;

import com.margin.repository.user.entity.UserCreationEntity;
import com.margin.repository.user.entity.UserEntity;
import com.margin.repository.user.entity.UserUpdateEntity;
import com.margin.service.user.model.UserCreationModel;
import com.margin.service.user.model.UserModel;
import com.margin.service.user.model.UserUpdateModel;
import org.springframework.stereotype.Component;

@Component
public class UserEntityConverter {

    public UserModel convert(UserEntity userEntity) {
        return new UserModel();
    }

    public UserCreationModel convert(UserCreationEntity userCreationEntity) {
        return new UserCreationModel();
    }

    public UserUpdateModel convert(UserUpdateEntity userUpdateEntity) {
        return new UserUpdateModel();
    }
}
