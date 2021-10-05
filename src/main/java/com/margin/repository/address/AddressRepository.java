package com.margin.repository.address;

import com.margin.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    @Transactional
    @Modifying
    @Query(value = "update addresses set deleted=true", nativeQuery = true)
    void deletedUpdate(Long id);
}
