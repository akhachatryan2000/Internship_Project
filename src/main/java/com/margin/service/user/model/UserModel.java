package com.margin.service.user.model;

import com.margin.service.role.RoleModel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

    private Long status;

    private List<RoleModel> roleModels;

}
