package com.example.petclinicmanager.controller;

import com.example.petclinicmanager.domain.Vet;
import com.example.petclinicmanager.repository.VetRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vets")
@RequiredArgsConstructor
public class VetController {

    private final VetRepository vetRepository;

    @GetMapping
    public String listVets(Model model) {
        List<Vet> vets = vetRepository.findAll();
        model.addAttribute("vets", vets);
        return "vets/list";
    }

    @GetMapping("/{id}")
    public String getVet(@PathVariable Long id, Model model) {
        Vet vet = vetRepository.findById(id).orElseThrow();
        model.addAttribute("vet", vet);
        return "vets/view";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("vet", new Vet());
        return "vets/add";
    }

    @PostMapping("/add")
    public String addVet(@ModelAttribute Vet vet) {
        vetRepository.save(vet);
        return "redirect:/vets";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Vet vet = vetRepository.findById(id).orElseThrow();
        model.addAttribute("vet", vet);
        return "vets/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateVet(@PathVariable Long id, @ModelAttribute Vet updatedVet) {
        Vet vet = vetRepository.findById(id).orElseThrow();
        vet.setName(updatedVet.getName());
        vet.setSpecialization(updatedVet.getSpecialization());
        vetRepository.save(vet);
        return "redirect:/vets";
    }

    @PostMapping("/delete/{id}")
    public String deleteVet(@PathVariable Long id) {
        vetRepository.deleteById(id);
        return "redirect:/vets";
    }
}
