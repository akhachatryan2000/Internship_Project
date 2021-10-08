package com.margin.repository.address;

import com.margin.entity.AddressEntity;
import com.margin.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    @Transactional
    @Modifying
    @Query(value = "update addresses set deleted=true where id=:id", nativeQuery = true)
    void deletedUpdate(Long id);

    @Query(value = "select  * from addresses where deleted=false order by id", nativeQuery = true)
    List<AddressEntity> findAllByOrdered();

    Optional<AddressEntity> findByIdAndDeletedIsFalse(Long id);
}
