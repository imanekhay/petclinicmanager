package com.example.petclinicmanager.controller;

import com.example.petclinicmanager.domain.PetOwner;
import com.example.petclinicmanager.domain.Address;
import com.example.petclinicmanager.repository.PetOwnerRepository;
import com.example.petclinicmanager.repository.AddressRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/petowners")
@RequiredArgsConstructor
public class PetOwnerController {

    private final PetOwnerRepository petOwnerRepository;
    private final AddressRepository addressRepository;

    @GetMapping
    public String listPetOwners(Model model) {
        List<PetOwner> owners = petOwnerRepository.findAll();
        model.addAttribute("owners", owners);
        return "petowners/list"; // Thymeleaf template
    }

    @GetMapping("/{id}")
    public String getPetOwner(@PathVariable Long id, Model model) {
        PetOwner owner = petOwnerRepository.findById(id).orElseThrow();
        model.addAttribute("owner", owner);
        return "petowners"; // Thymeleaf template
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("owner", new PetOwner());
        model.addAttribute("address", new Address());
        return "petowners/add"; // Thymeleaf template
    }

    @PostMapping("/add")
    public String addPetOwner(@ModelAttribute PetOwner owner) {
        addressRepository.save(owner.getAddress()); // now address is populated
        petOwnerRepository.save(owner);
        return "redirect:/petowners";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        PetOwner owner = petOwnerRepository.findById(id).orElseThrow();
        model.addAttribute("owner", owner);
        return "petowners/edit"; // Thymeleaf template
    }

    @PostMapping("/edit/{id}")
    public String updatePetOwner(@PathVariable Long id, @ModelAttribute PetOwner updatedOwner) {
        PetOwner owner = petOwnerRepository.findById(id).orElseThrow();
        owner.setName(updatedOwner.getName());
        // Update other fields as needed
        petOwnerRepository.save(owner);
        return "redirect:/petowners";
    }

    @PostMapping("/delete/{id}")
    public String deletePetOwner(@PathVariable Long id) {
        petOwnerRepository.deleteById(id);
        return "redirect:/petowners";
    }
}
