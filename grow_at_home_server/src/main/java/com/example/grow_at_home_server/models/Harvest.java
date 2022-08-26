package com.example.grow_at_home_server.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "harvests")
public class Harvest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="dateAdded")
    private LocalDate dateHarvested;
    @Column(name = "quantity")
    private int quantity;
    @JsonIgnoreProperties({"harvests"})
    @ManyToOne
    @JoinColumn(name = "plant_id", nullable = false)
    private Plant plant;

    public Harvest(String dateHarvested, int quantity, Plant plant) {
        this.dateHarvested = this.formatDate(dateHarvested);
        this.quantity = quantity;
        this.plant = plant;
    }

    public Harvest() {
    }
    public LocalDate formatDate(String givenDate) {

        if (givenDate == null){
            return null;
        }
        String[] splitString = givenDate.split("-");
        LocalDate newDate =  LocalDate.of(
                Integer.parseInt(splitString[0]),
                Integer.parseInt(splitString[1]),
                Integer.parseInt(splitString[2]));
        return newDate;
    }
    public Long getId() {
        return id;
    }

    public LocalDate getDateHarvested() {
        return dateHarvested;
    }

    public void setDateHarvested(LocalDate dateHarvested) {
        this.dateHarvested = dateHarvested;
    }

    public void setId(Long id) {
        this.id = id;
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
