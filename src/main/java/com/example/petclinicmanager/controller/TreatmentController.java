package com.example.petclinicmanager.controller;

import com.example.petclinicmanager.domain.Treatment;
import com.example.petclinicmanager.domain.Pet;
import com.example.petclinicmanager.domain.Vet;
import com.example.petclinicmanager.repository.TreatmentRepository;
import com.example.petclinicmanager.repository.PetRepository;
import com.example.petclinicmanager.repository.VetRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/treatments")
@RequiredArgsConstructor
public class TreatmentController {

    private final TreatmentRepository treatmentRepository;
    private final PetRepository petRepository;
    private final VetRepository vetRepository;

    @GetMapping
    public String listTreatments(Model model) {
        List<Treatment> treatments = treatmentRepository.findAll();
        model.addAttribute("treatments", treatments);
        return "treatments/list";
    }

    @GetMapping("/{id}")
    public String getTreatment(@PathVariable Long id, Model model) {
        Treatment treatment = treatmentRepository.findById(id).orElseThrow();
        model.addAttribute("treatment", treatment);
        return "treatments/view";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("treatment", new Treatment());
        model.addAttribute("pets", petRepository.findAll());
        model.addAttribute("vets", vetRepository.findAll());
        return "treatments/add";
    }

    @PostMapping("/add")
    public String addTreatment(@ModelAttribute Treatment treatment, @RequestParam Long petId, @RequestParam Long vetId) {
        Pet pet = petRepository.findById(petId).orElseThrow();
        Vet vet = vetRepository.findById(vetId).orElseThrow();
        treatment.setPet(pet);
        treatment.setVet(vet);
        treatmentRepository.save(treatment);
        return "redirect:/treatments";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Treatment treatment = treatmentRepository.findById(id).orElseThrow();
        model.addAttribute("treatment", treatment);
        model.addAttribute("pets", petRepository.findAll());
        model.addAttribute("vets", vetRepository.findAll());
        return "treatments/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateTreatment(@PathVariable Long id, @ModelAttribute Treatment updatedTreatment,
                                  @RequestParam Long petId, @RequestParam Long vetId) {
        Treatment treatment = treatmentRepository.findById(id).orElseThrow();
        treatment.setDescription(updatedTreatment.getDescription());
        treatment.setDate(updatedTreatment.getDate());
        Pet pet = petRepository.findById(petId).orElseThrow();
        Vet vet = vetRepository.findById(vetId).orElseThrow();
        treatment.setPet(pet);
        treatment.setVet(vet);
        treatmentRepository.save(treatment);
        return "redirect:/treatments";
    }

    @PostMapping("/delete/{id}")
    public String deleteTreatment(@PathVariable Long id) {
        treatmentRepository.deleteById(id);
        return "redirect:/treatments";
    }
}
