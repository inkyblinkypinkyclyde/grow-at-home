package com.example.grow_at_home_server.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "gardens")
public class Garden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="name")
    private String name;
    @JsonBackReference
    @OneToMany(mappedBy = "garden", fetch = FetchType.LAZY)
    private List<Bed> beds;

    public Garden(String name, List<Bed> beds) {
        this.name = name;
        this.beds = beds;
    }

    public Garden() {
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

    public List<Bed> getBeds() {
        return beds;
    }

    public void setBeds(List<Bed> beds) {
        this.beds = beds;
    }

    public void addBed(Bed bed){
        this.beds.add(bed);
    }
}
