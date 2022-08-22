package com.example.grow_at_home_server.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
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
    @JsonBackReference
    @OneToMany(mappedBy = "plant", fetch = FetchType.LAZY)
    private List<Harvest> harvests;
    @Column(name ="units")
    private Units units;
    @Column(name ="dateAdded")
    private Date dateAdded;
    @Column(name ="dateRemoved")
    private Date dateRemoved;
    @JsonBackReference
    @OneToMany(mappedBy = "plant", fetch = FetchType.LAZY)
    private List<WaterSensorEvent> waterSensorEvents;
    @JsonBackReference
    @OneToMany(mappedBy = "plant", fetch = FetchType.LAZY)
    private List<WaterEvent> waterEvents;
    @JsonIgnoreProperties({"plants"})
    @ManyToOne
    @JoinColumn(name = "bed_id", nullable = false)
    private Bed bed;

    public Plant(String name, String species, String tag, String produces, List<Harvest> harvests, Units units, Date dateAdded, Date dateRemoved, List<WaterSensorEvent> waterSensorEvents, List<WaterEvent> waterEvents, Bed bed) {
        this.name = name;
        this.species = species;
        this.tag = tag;
        this.produces = produces;
        this.harvests = harvests;
        this.units = units;
        this.dateAdded = dateAdded;
        this.dateRemoved = dateRemoved;
        this.waterSensorEvents = waterSensorEvents;
        this.waterEvents = waterEvents;
        this.bed = bed;
    }

    public Plant() {
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

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getDateRemoved() {
        return dateRemoved;
    }

    public void setDateRemoved(Date dateRemoved) {
        this.dateRemoved = dateRemoved;
    }

    public List<WaterSensorEvent> getWaterSensorEvents() {
        return waterSensorEvents;
    }

    public void setWaterSensorEvents(List<WaterSensorEvent> waterSensorEvents) {
        this.waterSensorEvents = waterSensorEvents;
    }

    public void addWaterSensorEvent(WaterSensorEvent waterSensorEvent){
        this.waterSensorEvents.add(waterSensorEvent);
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
