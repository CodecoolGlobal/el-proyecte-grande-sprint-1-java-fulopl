package com.codecool.backend.modell.entity.member;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq_gen")
    @SequenceGenerator(name = "address_seq_gen", sequenceName = "address_seq", initialValue = 101, allocationSize = 1)
    private long id;
    private String streetAndHouseNumber;
    private String settlement;
    private String country;
    private int zipCode;

    public Address(String streetAndHouseNumber, String settlement, String country, int zipCode) {
        this.streetAndHouseNumber = streetAndHouseNumber;
        this.settlement = settlement;
        this.country = country;
        this.zipCode = zipCode;
    }

    public Address() {}

}
