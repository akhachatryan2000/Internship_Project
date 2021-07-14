package com.margin.port.out.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public class AbstractJpaEntity {
    @Id
    @GeneratedValue
    private Long id;
}
