package com.example.petclinicmanager.repository;

import com.example.petclinicmanager.domain.PetOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetOwnerRepository extends JpaRepository<PetOwner, Long> {
    boolean existsByEmail(String email);
}
