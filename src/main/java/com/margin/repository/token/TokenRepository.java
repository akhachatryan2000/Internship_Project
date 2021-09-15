package com.margin.repository.token;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<AccessTokenEntity, Long> {
}
