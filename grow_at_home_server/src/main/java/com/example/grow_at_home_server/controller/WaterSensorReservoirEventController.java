package com.example.grow_at_home_server.controller;

import com.example.grow_at_home_server.models.Bed;
import com.example.grow_at_home_server.models.WaterSensorReservoirEvent;
import com.example.grow_at_home_server.repository.BedRepository;
import com.example.grow_at_home_server.repository.WaterSensorReservoirEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WaterSensorReservoirEventController {
    @Autowired
    WaterSensorReservoirEventRepository waterSensorReservoirEventRepository;

    @Autowired
    BedRepository bedRepository;

    @GetMapping(value = "/waterSensorReservoirEvents")
    public ResponseEntity<List<WaterSensorReservoirEvent>> getAllWaterSensorReservoirEvents(){
        return new ResponseEntity<>(waterSensorReservoirEventRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/waterSensorReservoirEvents/{id}")
    public ResponseEntity getFile(@PathVariable Long id){
        return new ResponseEntity<>(waterSensorReservoirEventRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/waterSensorReservoirEvents")
    public ResponseEntity<WaterSensorReservoirEvent> postFile(@RequestBody WaterSensorReservoirEvent waterSensorReservoirEvent){
        Optional<Bed> bed = bedRepository.findById(waterSensorReservoirEvent.getBedId());
        waterSensorReservoirEvent.setBed(bed.get());
        waterSensorReservoirEventRepository.save(waterSensorReservoirEvent);
        return new ResponseEntity<>(waterSensorReservoirEvent, HttpStatus.OK);
    }
}
