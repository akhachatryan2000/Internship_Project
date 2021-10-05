package com.margin.service.user.model;

import com.margin.common.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class UserModel {

    private Long id;

    private String username;

    private String password;

    private String name;

    private String surname;

    private UserRole role;
}
