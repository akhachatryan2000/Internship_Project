package com.margin.port.out.jpa.repository;

import com.margin.port.out.jpa.entity.DummyJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DummyJpaRepository extends JpaRepository<DummyJpaEntity, Long> {
}
