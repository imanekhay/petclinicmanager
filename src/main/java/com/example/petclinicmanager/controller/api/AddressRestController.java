package com.example.petclinicmanager.controller.api;


import com.example.petclinicmanager.domain.Address;
import com.example.petclinicmanager.repository.AddressRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/addresses")
public class AddressRestController extends AbstractRestController<Address, Long> {

    public AddressRestController(AddressRepository addressRepository) {
        super(addressRepository);
    }


}