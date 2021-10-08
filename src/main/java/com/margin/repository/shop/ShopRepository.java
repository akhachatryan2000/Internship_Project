package com.margin.repository.shop;

import com.margin.entity.CustomerEntity;
import com.margin.entity.ShopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface ShopRepository extends JpaRepository<ShopEntity, Long> {

    Optional<ShopEntity> findByName(String name);

    @Transactional
    @Modifying
    @Query(value = "Update shops set deleted=true where id=:id", nativeQuery = true)
    void updateDeleted(@Param("id") Long id);

    @Query(value = "select * from shops where deleted=false order by id", nativeQuery = true)
    List<ShopEntity> findAllOrdered();

    Optional<ShopEntity> findByIdAndDeletedIsFalse(Long id);
}
