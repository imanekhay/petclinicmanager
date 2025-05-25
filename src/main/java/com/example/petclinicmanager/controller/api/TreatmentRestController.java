package com.example.petclinicmanager.controller.api;

import com.example.petclinicmanager.domain.Treatment;
import com.example.petclinicmanager.repository.TreatmentRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/treatments")
public class TreatmentRestController extends AbstractRestController<Treatment, Long> {

    public TreatmentRestController(TreatmentRepository treatmentRepository) {
        super(treatmentRepository);
    }

}