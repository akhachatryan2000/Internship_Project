package com.margin.service.user.converter;

import com.margin.repository.user.entity.UserEntity;
import com.margin.service.user.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserEntityConverter {

    public UserModel convert(UserEntity user) {
        return new UserModel(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getName(),
                user.getSurname(),
                user.getRole()
        );
    }
}
