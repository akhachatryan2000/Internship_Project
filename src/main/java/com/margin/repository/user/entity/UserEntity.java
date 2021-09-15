package com.margin.repository.user.entity;

import com.margin.common.enums.UserRole;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String name;

//    @OneToMany(cascade = CascadeType.ALL)
//    private List<RoleEntity> roles;

    private String surname;
    @Enumerated(value = EnumType.STRING)
    private UserRole role;

}
