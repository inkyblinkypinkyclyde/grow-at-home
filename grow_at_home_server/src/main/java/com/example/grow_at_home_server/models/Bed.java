package com.example.grow_at_home_server.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "beds")
public class Bed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="name")
    private String name;
    @JsonIgnoreProperties({"bed"})
    @OneToMany(mappedBy = "bed", fetch = FetchType.LAZY)
    private List<Plant> plants;
    @Column(name = "column")
    private int reservoirCapacity;
    @JsonIgnoreProperties({"bed"})
    @OneToMany(mappedBy = "bed", fetch = FetchType.LAZY)
    private List<WaterSensorReservoirEvent> waterSensorReservoirEvents;
    @JsonIgnoreProperties({"beds"})
//    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "garden_id", nullable = false)
    private Garden garden;


    public Bed(String name, int reservoirCapacity, Garden garden) {
        this.name = name;
        this.plants = new ArrayList<>();
        this.reservoirCapacity = reservoirCapacity;
        this.waterSensorReservoirEvents = new ArrayList<>();
        this.garden = garden;
    }

    public Garden getGarden() {
        return garden;
    }

    public void setGarden(Garden garden) {
        this.garden = garden;
    }

    public Bed() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }

    public void addPlant(Plant plant){
        this.plants.add(plant);
    }

    public int getReservoirCapacity() {
        return reservoirCapacity;
    }

    public void setReservoirCapacity(int reservoirCapacity) {
        this.reservoirCapacity = reservoirCapacity;
    }

    public List<WaterSensorReservoirEvent> getWaterSensorReservoirEvents() {
        return waterSensorReservoirEvents;
    }

    public void setWaterSensorReservoirEvents(List<WaterSensorReservoirEvent> waterSensorReservoirEvents) {
        this.waterSensorReservoirEvents = waterSensorReservoirEvents;
    }

    public void addWaterSensorReservoirEvent(WaterSensorReservoirEvent waterSensorReservoirEvent){
        this.waterSensorReservoirEvents.add(waterSensorReservoirEvent);
    }
}
