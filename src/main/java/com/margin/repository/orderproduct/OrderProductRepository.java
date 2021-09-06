package com.margin.repository.orderproduct;

import com.margin.repository.orderproduct.entity.OrderProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface OrderProductRepository extends JpaRepository<OrderProductEntity, Long> {

    @Transactional
    @Modifying
    @Query(value = "Update order_products set deleted=true where id=:id", nativeQuery = true)
    void updateDeleted(@Param("id") Long id);
}
