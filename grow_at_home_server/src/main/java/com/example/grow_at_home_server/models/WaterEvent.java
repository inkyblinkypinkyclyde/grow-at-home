package com.example.grow_at_home_server.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "waterEvents")
public class WaterEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Transient
    private Long plantId;
    @Column(name = "datetime")
    private LocalDateTime eventDateTime;
    @Column(name = "duration")
    private int duration;
    @Column(name = "success")
    private boolean success;
    @JsonIgnoreProperties({"waterEvents"})
    @ManyToOne
    @JoinColumn(name = "plant_id", nullable = false)
    private Plant plant;

    public WaterEvent(String eventDateTime, int duration, boolean success, Plant plant, Long plantId) {
        this.eventDateTime = this.formatDateAndTime(eventDateTime);
        this.duration = duration;
        this.success = success;
        this.plant = plant;
        this.plantId = plantId;
    }

    private LocalDateTime formatDateAndTime(String givenDateTime) {
        String[] splitString = givenDateTime.split("[- :]");
        LocalDateTime newDateTime =  LocalDateTime.of(
                Integer.parseInt(splitString[0]),
                Integer.parseInt(splitString[1]),
                Integer.parseInt(splitString[2]),
                Integer.parseInt(splitString[3]),
                Integer.parseInt(splitString[4]),
                Integer.parseInt(splitString[5]));
        return newDateTime;
    }

    public WaterEvent() {
    }

    public Long getPlantId() {
        return plantId;
    }

    public void setPlantId(Long plantId) {
        this.plantId = plantId;
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }
}
