package com.margin.repository.orderproduct;

import com.margin.entity.CustomerEntity;
import com.margin.entity.OrderEntity;
import com.margin.entity.OrderProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface OrderProductRepository extends JpaRepository<OrderProductEntity, Long> {

    @Transactional
    @Modifying
    @Query(value = "Update order_products set deleted=true where id=:id", nativeQuery = true)
    void updateDeleted(@Param("id") Long id);

    @Query(value = "select * from order_products where deleted=false order by id", nativeQuery = true)
    List<OrderProductEntity> findAllOrdered();

    Optional<OrderProductEntity> findByIdAndDeletedIsFalse(Long id);
}
