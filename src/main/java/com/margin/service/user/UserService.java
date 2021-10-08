package com.margin.service.user;

import com.margin.common.config.PasswordEncoderImpl;
import com.margin.entity.UserEntity;
import com.margin.repository.user.UserRepository;
import com.margin.service.user.converter.UserEntityConverter;
import com.margin.service.user.converter.UserModelConverter;
import com.margin.service.user.model.UserCreationModel;
import com.margin.service.user.model.UserModel;
import com.margin.service.user.model.UserUpdateModel;
import com.margin.service.user.validator.UserIsValidValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private UserModelConverter userModelConverter;

    private UserEntityConverter userEntityConverter;

    private UserRepository userRepository;

    private UserIsValidValidator userIsValid;

    private PasswordEncoderImpl passwordEncoder;


    public UserModel get(Long id) {
        UserEntity user = userRepository.findById(id).get();
        if (user == null) {
            throw new EntityNotFoundException("User does not exist");
        }
        return userEntityConverter.convert(user);
    }

    public UserModel create(UserCreationModel userCreationModel) {
        if (userCreationModel == null) {
            return null;
        }
        userIsValid.userIsValid(userCreationModel.getPassword(), userCreationModel.getUsername());
        UserEntity user = userModelConverter.convert(userCreationModel);
        String password = userCreationModel.getPassword();
        String encoded = passwordEncoder.encode(password);
        user.setPassword(encoded);
        user = userRepository.save(user);
        return userEntityConverter.convert(user);
    }

    public UserModel update(UserUpdateModel userUpdateModel, Long id) {
        if (userUpdateModel == null || id == null) {
            return null;
        }
        userIsValid.userIsValid(userUpdateModel.getUsername());
        UserEntity user = userRepository.findByIdAndDeletedIsFalse(id).orElseThrow(() -> new EntityNotFoundException("Such user does not exist"));
        user = userModelConverter.convert(userUpdateModel, user);
        user = userRepository.save(user);
        return userEntityConverter.convert(user);
    }

    public List<UserModel> getAllUsers() {
        List<UserEntity> users = userRepository.findAllOrdered();
        return users.stream()
                .map(userEntity -> userEntityConverter.convert(userEntity))
                .collect(Collectors.toList());
    }

    public Boolean delete(Long id) {
        userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Such user does not exist"));
        userRepository.deletedUpdate(id);
        return true;
    }

    public Boolean forceDelete(Long id) {
        userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Such user does not exist"));
        userRepository.deleteById(id);
        return true;
    }
}


