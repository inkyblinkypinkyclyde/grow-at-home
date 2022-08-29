package com.example.grow_at_home_server.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "waterSensorReservoirEvents")
public class WaterSensorReservoirEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private Long bedId;
    @Column(name = "datetime")
    private LocalDateTime eventDateTime;

    @Column(name = "wet")
    private boolean wet;
    @JsonIgnoreProperties({"waterSensorReservoirEvents"})
    @ManyToOne
    @JoinColumn(name = "bed_id", nullable = false)
    private Bed bed;


    public WaterSensorReservoirEvent(String eventDateTime, boolean wet, Bed bed, Long bedId) {
        this.eventDateTime = this.formatDateAndTime(eventDateTime);
        this.wet = wet;
        this.bed = bed;
        this.bedId = bedId;
    }

    public WaterSensorReservoirEvent() {
    }


    public Long getBedId() {
        return bedId;
    }

    public void setBedId(Long bedId) {
        this.bedId = bedId;
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
    public Long getId() {
        return id;
    }

    public boolean isWet() {
        return wet;
    }

    public void setWet(boolean wet) {
        this.wet = wet;
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

    public Bed getBed() {
        return bed;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }
}
