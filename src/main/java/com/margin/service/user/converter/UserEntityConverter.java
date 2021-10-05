package com.margin.service.user.converter;

import com.margin.entity.UserEntity;
import com.margin.service.user.model.UserModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
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
