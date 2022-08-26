package com.example.grow_at_home_server.controller;

import com.example.grow_at_home_server.models.Bed;
import com.example.grow_at_home_server.repository.BedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BedController {
    @Autowired
    BedRepository bedRepository;

    @GetMapping(value = "/beds")
    public ResponseEntity <List<Bed>> getAllBeds(){
        return new ResponseEntity<>(bedRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/beds/{id}")
    public ResponseEntity getFile(@PathVariable Long id){
        return new ResponseEntity<>(bedRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/beds")
    public ResponseEntity<Bed> postFile(@RequestBody Bed bed){
        bedRepository.save(bed);
        return new ResponseEntity<>(bed, HttpStatus.OK);
    }

    @DeleteMapping(value = "/beds/{id}")
    public ResponseEntity<List<Bed>> deleteBed(@PathVariable Long id){
        Bed found = bedRepository.getOne(id);
        bedRepository.delete(found);
        return new ResponseEntity<>(bedRepository.findAll(), HttpStatus.OK );
    }
}
