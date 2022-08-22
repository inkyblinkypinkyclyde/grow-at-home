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
    @Column(name = "datetime")
    private LocalDateTime eventDateTime;
    @JsonIgnoreProperties({"waterSensorReservoirEvents"})
    @ManyToOne
    @JoinColumn(name = "bed_id", nullable = false)
    private Bed bed;

    public WaterSensorReservoirEvent(LocalDateTime eventDateTime, Bed bed) {
        this.eventDateTime = eventDateTime;
        this.bed = bed;
    }

    public WaterSensorReservoirEvent() {
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

    public Bed getBed() {
        return bed;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }
}
