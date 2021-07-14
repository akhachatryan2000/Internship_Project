package com.margin.port.out.jpa.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Table(name = "person")
@Entity(name = "UserJpaEntity")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class DummyJpaEntity extends AbstractJpaEntity {
    @Column(name = "name")
    String name;
}
