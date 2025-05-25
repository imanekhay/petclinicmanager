package com.example.petclinicmanager.controller;

import com.example.petclinicmanager.domain.Address;
import com.example.petclinicmanager.repository.AddressRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressRepository addressRepository;

    @GetMapping
    public String listAddresses(Model model) {
        List<Address> addresses = addressRepository.findAll();
        model.addAttribute("addresses", addresses);
        return "addresses/list";
    }

    @GetMapping("/{id}")
    public String getAddress(@PathVariable Long id, Model model) {
        Address address = addressRepository.findById(id).orElseThrow();
        model.addAttribute("address", address);
        return "addresses/view";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("address", new Address());
        return "addresses/add";
    }

    @PostMapping("/add")
    public String addAddress(@ModelAttribute Address address) {
        addressRepository.save(address);
        return "redirect:/addresses";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Address address = addressRepository.findById(id).orElseThrow();
        model.addAttribute("address", address);
        return "addresses/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateAddress(@PathVariable Long id, @ModelAttribute Address updatedAddress) {
        Address address = addressRepository.findById(id).orElseThrow();
        address.setStreet(updatedAddress.getStreet());
        address.setCity(updatedAddress.getCity());
        addressRepository.save(address);
        return "redirect:/addresses";
    }

    @PostMapping("/delete/{id}")
    public String deleteAddress(@PathVariable Long id) {
        addressRepository.deleteById(id);
        return "redirect:/addresses";
    }
}
