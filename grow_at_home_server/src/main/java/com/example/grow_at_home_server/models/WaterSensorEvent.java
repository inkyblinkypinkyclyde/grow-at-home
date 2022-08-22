package com.example.grow_at_home_server.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "waterSensorEvents")
public class WaterSensorEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "datetime")
    private LocalDateTime eventDateTime;
    @JsonIgnoreProperties({"waterSensorEvents"})
    @ManyToOne
    @JoinColumn(name = "plant_id", nullable = false)
    private Plant plant;

    public WaterSensorEvent(LocalDateTime eventDateTime, Plant plant) {
        this.eventDateTime = eventDateTime;
        this.plant = plant;
    }

    public WaterSensorEvent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getEventDateTime() {
        return eventDateTime;
    }

    public void setEventDateTime(LocalDateTime eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }
}
