package com.margin.controller.user;

import com.margin.common.exception.response.GenericResponse;
import com.margin.controller.user.dto.UserDto;
import com.margin.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserCRUDController {

//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/{id}")
//    public GenericResponse<UserDto> get(@PathVariable(name = "id") Long id) {
//
//
//
//    }

}
