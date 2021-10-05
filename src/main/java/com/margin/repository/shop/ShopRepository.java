package com.margin.repository.shop;

import com.margin.entity.ShopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface ShopRepository extends JpaRepository<ShopEntity, Long> {

    Optional<ShopEntity> findByName(String name);

    @Transactional
    @Modifying
    @Query(value = "Update shops set deleted=true where id=:id", nativeQuery = true)
    void updateDeleted(@Param("id") Long id);
}
