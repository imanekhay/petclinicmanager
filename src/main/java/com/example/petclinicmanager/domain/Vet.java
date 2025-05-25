package com.example.petclinicmanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "vets")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Vet extends AbstractDomain<Long> {

    @Column(nullable = false)
    private String name;

    private String specialization;

    @OneToMany(mappedBy = "vet", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Pet> pets;
}
