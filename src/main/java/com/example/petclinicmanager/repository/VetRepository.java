package com.example.petclinicmanager.repository;

import com.example.petclinicmanager.domain.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VetRepository extends JpaRepository<Vet, Long> {
}
