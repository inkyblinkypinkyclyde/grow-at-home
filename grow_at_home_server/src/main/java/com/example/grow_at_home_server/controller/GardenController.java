package com.example.grow_at_home_server.controller;

import com.example.grow_at_home_server.models.Garden;
import com.example.grow_at_home_server.repository.GardenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GardenController {
    @Autowired
    GardenRepository gardenRepository;

    @GetMapping(value = "/gardens")
    public ResponseEntity<List<Garden>> getAllGardens(){
        return new ResponseEntity<>(gardenRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/gardens/{id}")
    public ResponseEntity getFile(@PathVariable Long id){
        return new ResponseEntity<>(gardenRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/gardens")
    public ResponseEntity<Garden> postFile(@RequestBody Garden garden){
        gardenRepository.save(garden);
        return new ResponseEntity<>(garden, HttpStatus.OK);
    }
}
