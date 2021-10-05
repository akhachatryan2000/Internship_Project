package com.margin.repository.customer;

import com.margin.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    @Transactional
    @Modifying
    @Query(value = "Update customers set deleted=true where id=:id", nativeQuery = true)
    void deletedUpdate(@Param("id") Long id);
}
