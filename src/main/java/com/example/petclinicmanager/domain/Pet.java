package com.example.petclinicmanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "pets")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Pet extends AbstractDomain<Long> {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;

    private LocalDate birthDate;

    // ManyToOne with Owner
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "owner_id")
    private PetOwner owner;

    // ManyToOne with Vet
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "vet_id")
    private Vet vet;

    // ManyToMany with Treatments
    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "pet_treatments",
            joinColumns = @JoinColumn(name = "pet_id"),
            inverseJoinColumns = @JoinColumn(name = "treatment_id")
    )
    private Set<Treatment> treatments;
}
