package com.margin.controller.user.dto;

import com.margin.common.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class UserCreationDto {

    private String username;

    private String password;

    private String name;

    private String surname;

    private UserRole role;
}
