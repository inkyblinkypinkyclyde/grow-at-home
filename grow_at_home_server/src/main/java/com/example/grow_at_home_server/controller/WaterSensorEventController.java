package com.example.grow_at_home_server.controller;

import com.example.grow_at_home_server.models.WaterSensorEvent;
import com.example.grow_at_home_server.repository.WaterSensorEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WaterSensorEventController {
    @Autowired
    WaterSensorEventRepository waterSensorEventRepository;

    @GetMapping(value = "/WaterSensorEvents")
    public ResponseEntity<List<WaterSensorEvent>> getAllWaterSensorEvents(){
        return new ResponseEntity<>(waterSensorEventRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/WaterSensorEvents/{id}")
    public ResponseEntity getFile(@PathVariable Long id){
        return new ResponseEntity<>(waterSensorEventRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/WaterSensorReservoirEvents")
    public ResponseEntity<WaterSensorEvent> postFile(@RequestBody WaterSensorEvent waterSensorEvent){
        waterSensorEventRepository.save(waterSensorEvent);
        return new ResponseEntity<>(waterSensorEvent, HttpStatus.OK);
    }
}
