package com.example.petclinicmanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "petowners")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class PetOwner extends AbstractDomain<Long> {

    @Column(nullable = false)
    private String name;


    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    // OneToOne with Address
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    // OneToMany with Pets
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Pet> pets;
}
