package com.example.grow_at_home_server.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZoneOffset;
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

    @Column(name = "averageWaterInterval")
    private double averageWaterInterval;
    @Column(name = "thirstyMultiplier")
    private double thirstyMultiplier;

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
        this.waterEvents = new ArrayList<>();
        this.bed = bed;
        this.averageWaterInterval = 0;
        this.thirstyMultiplier = 1;
    }

    public Plant() {
    }

    public double getThirstyMultiplier() {
        return thirstyMultiplier;
    }

    public void setThirstyMultiplier(double thirstyMultiplier) {
        this.thirstyMultiplier = thirstyMultiplier;
    }

    public void generateAverageWaterInterval(){
        System.out.println("called method");
        if (this.waterEvents.size() > 5){
            System.out.println("passed if statement");
            double total = 0;
            for (int i = 0; i < 3; i++){
                long currentTimeDate = waterEvents.get(waterEvents.size()-(i+1)).getEventDateTime().toEpochSecond(ZoneOffset.UTC);
                long previousTimeDate = waterEvents.get(waterEvents.size()-(i+2)).getEventDateTime().toEpochSecond(ZoneOffset.UTC);
                total = total + (currentTimeDate - previousTimeDate);
            }
            double average = total/3;
            setAverageWaterInterval(average);
            System.out.println("set average");
        } else {
            setAverageWaterInterval(0);
        }
    }

    public double getAverageWaterInterval() {
        return averageWaterInterval;
    }

    public void setAverageWaterInterval(double averageWaterInterval) {
        this.averageWaterInterval = averageWaterInterval;
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
