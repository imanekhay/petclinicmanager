package com.example.petclinicmanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.time.LocalDate;


import java.util.Set;

@Entity
@Table(name = "treatments")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Treatment extends AbstractDomain<Long> {

    @Column(nullable = false)
    private String name;

    private String description;

    @ManyToOne(optional = false)
    @JsonIgnore
    private Pet pet;

    @ManyToOne(optional = false)
    @JsonIgnore
    private Vet vet;

    private LocalDate date;
}
