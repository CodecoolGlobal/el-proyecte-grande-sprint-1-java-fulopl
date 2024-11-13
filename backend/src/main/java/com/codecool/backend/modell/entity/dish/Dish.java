package com.codecool.backend.modell.entity.dish;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
@Getter
@Entity
@Setter
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dish_seq_gen")
    @SequenceGenerator(name = "dish_seq_gen", sequenceName = "dish_seq", initialValue = 101, allocationSize = 1)
    private long id;

    private String name;

    private String description;

    private double price;

    @ManyToMany
    private Set<Allergen> allergens;

    public Dish() {
    }

    public Dish(String name, String description, double price, Set<Allergen> allergens) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.allergens = new HashSet<>(allergens);
    }
}
