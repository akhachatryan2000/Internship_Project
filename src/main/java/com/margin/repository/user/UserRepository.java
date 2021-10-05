package com.margin.repository.user;

import com.margin.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);

    Boolean deleteByUsername(String username);

    @Modifying
    @Transactional
    @Query(value = "update users set deleted=true", nativeQuery = true)
    void deletedUpdate(Long id);
}
