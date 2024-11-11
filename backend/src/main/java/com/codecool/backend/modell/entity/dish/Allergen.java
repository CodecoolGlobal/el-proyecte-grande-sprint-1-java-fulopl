package com.codecool.backend.modell.entity.dish;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Setter
public class Allergen {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "allergen_seq_gen")
    @SequenceGenerator(name = "allergen_seq_gen", sequenceName = "allergen_seq", initialValue = 101, allocationSize = 1)
    private Long id;

    private String name;

    private int number;


    public Allergen(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public Allergen() {
    }
}
