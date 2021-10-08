package com.margin.repository.order;

import com.margin.entity.CustomerEntity;
import com.margin.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    @Transactional
    @Modifying
    @Query(value = "update orders set deleted=true where id=:id", nativeQuery = true)
    void deleteUpdated(@Param("id") Long id);

    @Query(value = "select * from orders where deleted=false order by id", nativeQuery = true)
    List<OrderEntity> findAllOrdered();

    Optional<OrderEntity> findByIdAndDeletedIsFalse(Long id);
}
