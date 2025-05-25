package com.example.petclinicmanager.repository;

import com.example.petclinicmanager.domain.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
}
