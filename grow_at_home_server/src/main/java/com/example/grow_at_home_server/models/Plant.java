package com.example.grow_at_home_server.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "plants")
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name ="name")
    private String name;
    @Column(name ="species")
    private String species;
    @Column(name ="tag")
    private String tag;
    @Column(name ="produces")
    private String produces;
    @JsonIgnoreProperties({"plant"})
    @OneToMany(mappedBy = "plant", fetch = FetchType.LAZY)
    private List<Harvest> harvests;
    @Column(name ="units")
    private Units units;
    @Column(name ="dateAdded")
    private LocalDate dateAdded;
    @Column(name ="dateRemoved")
    private LocalDate dateRemoved;
//    @JsonIgnoreProperties({"plant"})
//    @OneToMany(mappedBy = "plant", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
//    private List<WaterSensorEvent> waterSensorEvents;
    @JsonIgnoreProperties({"plant"})
    @OneToMany(mappedBy = "plant", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<WaterEvent> waterEvents;
    @JsonIgnoreProperties({"plants"})
    @ManyToOne
    @JoinColumn(name = "bed_id", nullable = false)
    private Bed bed;

    public Plant(String name, String species, String tag, String produces, Units units, String dateAdded, Bed bed) {
        this.name = name;
        this.species = species;
        this.tag = tag;
        this.produces = produces;
        this.harvests = new ArrayList<>();
        this.units = units;
        this.dateAdded = this.formatDate(dateAdded);
        this.dateRemoved = null;
//        this.waterSensorEvents = new ArrayList<>();
        this.waterEvents = new ArrayList<>();
        this.bed = bed;
    }

    public Plant() {
    }

    public LocalDate formatDate(String givenDate) {
        System.out.println(givenDate);
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


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Harvest> getHarvests() {
        return harvests;
    }

    public void setHarvests(List<Harvest> harvests) {
        this.harvests = harvests;
    }

    public void addHarvest(Harvest harvest){
        this.harvests.add(harvest);
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getProduces() {
        return produces;
    }

    public void setProduces(String produces) {
        this.produces = produces;
    }

    public Units getUnits() {
        return units;
    }

    public void setUnits(Units units) {
        this.units = units;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = this.formatDate(dateAdded);
    }

    public LocalDate getDateRemoved() {
        return dateRemoved;
    }

    public void setDateRemoved(String dateRemoved) {
        this.dateRemoved = this.formatDate(dateRemoved);
    }

//    public List<WaterSensorEvent> getWaterSensorEvents() {
//        return waterSensorEvents;
//    }

//    public void setWaterSensorEvents(List<WaterSensorEvent> waterSensorEvents) {
//        this.waterSensorEvents = waterSensorEvents;
//    }

//    public void addWaterSensorEvent(WaterSensorEvent waterSensorEvent){
//        this.waterSensorEvents.add(waterSensorEvent);
//    }

    public List<WaterEvent> getWaterEvents() {
        return waterEvents;
    }

    public void setWaterEvents(List<WaterEvent> waterEvents) {
        this.waterEvents = waterEvents;
    }

    public void addWaterEvent(WaterEvent waterEvent){
        this.waterEvents.add(waterEvent);
    }

    public Bed getBed() {
        return bed;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }

}
