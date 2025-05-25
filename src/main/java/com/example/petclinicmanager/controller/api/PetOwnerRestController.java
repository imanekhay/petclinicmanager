package com.example.petclinicmanager.controller.api;

import com.example.petclinicmanager.domain.PetOwner;
import com.example.petclinicmanager.repository.PetOwnerRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/petowners")
public class PetOwnerRestController extends AbstractRestController<PetOwner, Long> {

    public PetOwnerRestController(PetOwnerRepository petOwnerRepository) {
        super(petOwnerRepository);
    }


}
