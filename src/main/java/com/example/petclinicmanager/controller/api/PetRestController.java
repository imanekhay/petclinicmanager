package com.example.petclinicmanager.controller.api;

import com.example.petclinicmanager.domain.Pet;
import com.example.petclinicmanager.repository.PetRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pets")
public class PetRestController extends AbstractRestController<Pet, Long> {

    public PetRestController(PetRepository petRepository) {
        super(petRepository);
    }


}
