package com.margin.repository.token;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "access_token")
public class AccessTokenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    public AccessTokenEntity() {

    }

    public AccessTokenEntity(String token) {
        this.token = token;
    }
}
