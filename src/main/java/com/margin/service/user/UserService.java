package com.margin.service.user;

import com.margin.repository.user.UserRepository;
import com.margin.repository.user.entity.UserEntity;
import com.margin.service.user.converter.UserEntityConverter;
import com.margin.service.user.converter.UserModelConverter;
import com.margin.service.user.model.UserCreationModel;
import com.margin.service.user.model.UserModel;
import com.margin.service.user.model.UserUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserEntityConverter userEntityConverter;

    @Autowired
    private UserModelConverter userModelConverter;

    public UserModel get(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No such user with id" + id));
        UserModel userModel = userEntityConverter.convert(user);
        return userModel;
    }

    public UserModel create(UserCreationModel userCreationModel) {
        UserEntity user = userModelConverter.convert(userCreationModel);
        user = userRepository.save(user);
        UserModel userModel = userEntityConverter.convert(user);
        return userModel;
    }

    public UserModel update(UserUpdateModel userModel, Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("There is no such user with id " + id));
        user = userModelConverter.convert(userModel, user);
        user = userRepository.save(user);
        UserModel us = userEntityConverter.convert(user);
        return us;
    }

    public Boolean delete(Long id) {
        userRepository.deleteById(id);
        return true;
    }
}
