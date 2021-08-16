package com.margin.repository.address;

import com.margin.repository.address.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity,Long > {
}
