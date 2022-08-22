package com.example.grow_at_home_server.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "harvests")
public class Harvest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "units")
    private Units units;
    @Column(name = "quantity")
    private int quantity;
    @JsonIgnoreProperties({"harvests"})
    @ManyToOne
    @JoinColumn(name = "plant_id", nullable = false)
    private Plant plant;

    public Harvest(Units units, int quantity, Plant plant) {
        this.units = units;
        this.quantity = quantity;
        this.plant = plant;
    }

    public Harvest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Units getUnits() {
        return units;
    }

    public void setUnits(Units units) {
        this.units = units;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }
}
