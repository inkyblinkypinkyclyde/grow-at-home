package com.example.grow_at_home_server.controller;

import com.example.grow_at_home_server.models.Bed;
import com.example.grow_at_home_server.models.Plant;
import com.example.grow_at_home_server.repository.PlantRepository;
import org.hibernate.annotations.OnDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlantController {
    @Autowired
    PlantRepository plantRepository;

    @GetMapping(value = "/plants")
    public ResponseEntity<List<Plant>> getAllplants(){
        return new ResponseEntity<>(plantRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/plants/{id}")
    public ResponseEntity getFile(@PathVariable Long id){
        return new ResponseEntity<>(plantRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/plants")
    public ResponseEntity<Plant> postFile(@RequestBody Plant plant){
        plantRepository.save(plant);
        return new ResponseEntity<>(plant, HttpStatus.OK);
    }

    @DeleteMapping(value = "/plants/{id}")
    public ResponseEntity<List<Plant>> deletePlant(@PathVariable Long id){
        Plant found = plantRepository.getOne(id);
        plantRepository.delete(found);
        return new ResponseEntity<>(plantRepository.findAll(), HttpStatus.OK );
    }
}
