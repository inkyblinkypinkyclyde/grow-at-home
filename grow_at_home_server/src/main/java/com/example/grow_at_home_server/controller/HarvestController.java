package com.example.grow_at_home_server.controller;

import com.example.grow_at_home_server.models.Harvest;
import com.example.grow_at_home_server.repository.HarvestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HarvestController {
    @Autowired
    HarvestRepository harvestRepository;

    @GetMapping(value = "/harvests")
    public ResponseEntity<List<Harvest>> getAllHArvestss(){
        return new ResponseEntity<>(harvestRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/harvests/{id}")
    public ResponseEntity getFile(@PathVariable Long id){
        return new ResponseEntity<>(harvestRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/harvests")
    public ResponseEntity<Harvest> postFile(@RequestBody Harvest harvest){
        harvestRepository.save(harvest);
        return new ResponseEntity<>(harvest, HttpStatus.OK);
    }
}
