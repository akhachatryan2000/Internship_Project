package com.margin.service.user;

import com.margin.repository.user.UserRepository;
import com.margin.repository.user.entity.UserEntity;
import com.margin.service.user.converter.UserEntityConverter;
import com.margin.service.user.converter.UserModelConverter;
import com.margin.service.user.model.UserCreationModel;
import com.margin.service.user.model.UserModel;
import com.margin.service.user.model.UserUpdateModel;
import com.margin.service.user.validator.UserHasPasswordValidator;
import com.margin.service.user.validator.UserHasUsernameValidator;
import com.margin.service.user.validator.UsernameIsUniqueVaidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserModelConverter userModelConverter;

    @Autowired
    private UserEntityConverter userEntityConverter;

    @Autowired
    private UserHasUsernameValidator userHasUsernameValidator;

    @Autowired
    private UserHasPasswordValidator userHasPasswordValidator;

    @Autowired
    private UserRepository userRepository;


    public UserModel get(Long id) {
        UserEntity user = userRepository.findById(id).get();
        if (user == null) {
            throw new EntityNotFoundException("User does not exist");
        }
        UserModel userModel = userEntityConverter.convert(user);
        return userModel;
    }

    public UserModel create(UserCreationModel userCreationModel) {
        if (userCreationModel == null) {
            return null;
        }
        userHasUsernameValidator.userHasUsernameValidator(userCreationModel.getUsername());
        userHasPasswordValidator.userHasPasswordValidator(userCreationModel.getPassword());
        // String password = userCreationModel.getPassword();
        UserEntity user = userModelConverter.convert(userCreationModel);
        //  user.setPassword(encoded);
        user = userRepository.save(user);
        UserModel userModel = userEntityConverter.convert(user);
        return userModel;
    }

    public UserModel update(UserUpdateModel userUpdateModel, Long id) {
        if (userUpdateModel == null || id == null) {
            return null;
        }
        userHasUsernameValidator.userHasUsernameValidator(userUpdateModel.getUsername());
        userHasPasswordValidator.userHasPasswordValidator(userUpdateModel.getPassword());
        String password = userUpdateModel.getPassword();
        // String encoded = bCryptPasswordEncoder.encode(password);
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("The user does not exist"));
        user = userModelConverter.convert(userUpdateModel, user);
        //  user.setPassword(encoded);
        user = userRepository.save(user);
        UserModel userModel = userEntityConverter.convert(user);
        return userModel;
    }

    public List<UserModel> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        List<UserModel> userModels = users.stream()
                .map(userEntity -> userEntityConverter.convert(userEntity))
                .collect(Collectors.toList());
        return userModels;
    }

    public Boolean delete(Long id) {
        userRepository.deleteById(id);
        return true;
    }
}


