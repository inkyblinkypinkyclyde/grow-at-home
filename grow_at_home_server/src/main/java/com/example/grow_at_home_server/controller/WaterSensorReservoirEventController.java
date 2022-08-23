package com.example.grow_at_home_server.controller;

import com.example.grow_at_home_server.models.WaterSensorReservoirEvent;
import com.example.grow_at_home_server.repository.WaterSensorReservoirEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WaterSensorReservoirEventController {
    @Autowired
    WaterSensorReservoirEventRepository waterSensorReservoirEventRepository;

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
        waterSensorReservoirEventRepository.save(waterSensorReservoirEvent);
        return new ResponseEntity<>(waterSensorReservoirEvent, HttpStatus.OK);
    }
}
