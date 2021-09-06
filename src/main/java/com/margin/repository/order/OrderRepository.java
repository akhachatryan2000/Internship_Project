package com.margin.repository.order;

import com.margin.repository.order.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE orders set deleted=true where id=:id", nativeQuery = true)
    void deleteUpdated(@Param("id") Long id);
}
