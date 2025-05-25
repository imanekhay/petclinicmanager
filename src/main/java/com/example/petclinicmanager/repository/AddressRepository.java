package com.example.petclinicmanager.repository;

import com.example.petclinicmanager.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
