package com.margin.controller.user.dto;

import com.margin.common.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class UserUpdateDto {

    private Long id;

    private String username;

    private String password;

    private String name;

    private String surname;

    private UserRole role;
}
