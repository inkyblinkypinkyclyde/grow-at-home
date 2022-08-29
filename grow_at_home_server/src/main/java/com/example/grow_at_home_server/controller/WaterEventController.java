package com.example.grow_at_home_server.controller;

import com.example.grow_at_home_server.models.Bed;
import com.example.grow_at_home_server.models.Plant;
import com.example.grow_at_home_server.models.WaterEvent;
import com.example.grow_at_home_server.repository.PlantRepository;
import com.example.grow_at_home_server.repository.WaterEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WaterEventController {
    @Autowired
    WaterEventRepository waterEventRepository;
    @Autowired
    PlantRepository plantRepository;

    @GetMapping(value = "/waterEvents")
    public ResponseEntity<List<WaterEvent>> getAllwaterEvents(){
        return new ResponseEntity<>(waterEventRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/waterEvents/{id}")
    public ResponseEntity getFile(@PathVariable Long id){
        return new ResponseEntity<>(waterEventRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/waterEvents")
    public ResponseEntity<WaterEvent> postFile(@RequestBody WaterEvent waterEvent){
        Optional<Plant> plant = plantRepository.findById(waterEvent.getPlantId());
        waterEvent.setPlant(plant.get());
        waterEventRepository.save(waterEvent);
        return new ResponseEntity<>(waterEvent, HttpStatus.OK);
    }
}
