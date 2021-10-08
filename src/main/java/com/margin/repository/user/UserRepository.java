package com.margin.repository.user;

import com.margin.entity.CustomerEntity;
import com.margin.entity.ShopEntity;
import com.margin.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);

    @Modifying
    @Transactional
    @Query(value = "update users set deleted=true where id=:id", nativeQuery = true)
    void deletedUpdate(Long id);

    @Query(value = "select * from users where deleted=false order by id", nativeQuery = true)
    List<UserEntity> findAllOrdered();

    Optional<UserEntity> findByIdAndDeletedIsFalse(Long id);
}
