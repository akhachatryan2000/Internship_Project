package com.margin.repository.address;

import com.margin.repository.address.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    @Query(value = "select * from addresses where addressLine1=:addressLine1", nativeQuery = true)
    AddressEntity findAddressEntityByAddressLine1(@Param("addressLine1") String addressLine1);

    @Transactional
    @Modifying
    @Query(value = "Update addresses set deleted=true where id=:id", nativeQuery = true)
    void deletedUpdate(@Param("id") Long id);
}
