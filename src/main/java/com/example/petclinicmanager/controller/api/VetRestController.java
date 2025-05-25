package com.example.petclinicmanager.controller.api;

import com.example.petclinicmanager.domain.Vet;
import com.example.petclinicmanager.repository.VetRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vets")
public class VetRestController extends AbstractRestController<Vet, Long> {

    public VetRestController(VetRepository vetRepository) {
        super(vetRepository);
    }


}
