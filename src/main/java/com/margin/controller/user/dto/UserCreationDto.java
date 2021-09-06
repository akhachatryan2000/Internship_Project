package com.margin.controller.user.dto;

import com.margin.controller.role.RoleDTO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class UserCreationDto {

    private String username;

    private String password;

    private String name;

    private String surname;

    private Long status;

    private List<RoleDTO> roles;
}
