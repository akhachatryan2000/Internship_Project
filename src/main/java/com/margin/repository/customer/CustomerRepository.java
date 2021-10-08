package com.margin.repository.customer;

import com.margin.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    @Transactional
    @Modifying
    @Query(value = "Update customers set deleted=true where id=:id", nativeQuery = true)
    void deletedUpdate(@Param("id") Long id);

    @Query(value = "select * from customers where deleted=false order by id", nativeQuery = true)
    List<CustomerEntity> findAllOrdered();

    Optional<CustomerEntity> findByIdAndDeletedIsFalse(Long id);
}
