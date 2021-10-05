package com.margin.repository.product;

import com.margin.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    Optional<String> findByName(String name);

    @Transactional
    @Modifying
    @Query(value = "Update products set deleted=true where id=:id", nativeQuery = true)
    void updateDeleted(@Param("id") Long id);
}
