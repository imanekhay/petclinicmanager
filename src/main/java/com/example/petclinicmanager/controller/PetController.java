package com.example.petclinicmanager.controller;

import com.example.petclinicmanager.domain.Pet;
import com.example.petclinicmanager.domain.PetOwner;
import com.example.petclinicmanager.repository.PetRepository;
import com.example.petclinicmanager.repository.PetOwnerRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetRepository petRepository;
    private final PetOwnerRepository petOwnerRepository;

    @GetMapping
    public String listPets(Model model) {
        List<Pet> pets = petRepository.findAll();
        model.addAttribute("pets", pets);
        return "pets/list";
    }

    @GetMapping("/{id}")
    public String getPet(@PathVariable Long id, Model model) {
        Pet pet = petRepository.findById(id).orElseThrow();
        model.addAttribute("pet", pet);
        return "pets/view";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("pet", new Pet());
        model.addAttribute("owners", petOwnerRepository.findAll());
        return "pets/add";
    }

    @PostMapping("/add")
    public String addPet(@ModelAttribute Pet pet, @RequestParam Long ownerId) {
        PetOwner owner = petOwnerRepository.findById(ownerId).orElseThrow();
        pet.setOwner(owner);
        petRepository.save(pet);
        return "redirect:/pets";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Pet pet = petRepository.findById(id).orElseThrow();
        model.addAttribute("pet", pet);
        model.addAttribute("owners", petOwnerRepository.findAll());
        return "pets/edit";
    }

    @PostMapping("/edit/{id}")
    public String updatePet(@PathVariable Long id, @ModelAttribute Pet updatedPet, @RequestParam Long ownerId) {
        Pet pet = petRepository.findById(id).orElseThrow();
        pet.setName(updatedPet.getName());
        pet.setType(updatedPet.getType());
        PetOwner owner = petOwnerRepository.findById(ownerId).orElseThrow();
        pet.setOwner(owner);
        petRepository.save(pet);
        return "redirect:/pets";
    }

    @PostMapping("/delete/{id}")
    public String deletePet(@PathVariable Long id) {
        petRepository.deleteById(id);
        return "redirect:/pets";
    }
}
