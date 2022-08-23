package com.example.grow_at_home_server.components;

import com.example.grow_at_home_server.models.*;
import com.example.grow_at_home_server.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    BedRepository bedRepository;
    @Autowired
    GardenRepository gardenRepository;
    @Autowired
    HarvestRepository harvestRepository;
    @Autowired
    PlantRepository plantRepository;
    @Autowired
    WaterEventRepository waterEventRepository;
    @Autowired
    WaterSensorEventRepository waterSensorEventRepository;
    @Autowired
    WaterSensorReservoirEventRepository waterSensorReservoirEventRepository;
    public void run(ApplicationArguments args){
        Garden garden0 = new Garden("Front Garden");
        gardenRepository.save(garden0);
        Garden garden1 = new Garden("Back Garden");
        gardenRepository.save(garden1);
        Garden garden2 = new Garden("Smart Garden");
        gardenRepository.save(garden2);
        Bed bed00 = new Bed("Rose Bed", 1000, garden0);
        bedRepository.save(bed00);
        Bed bed01 = new Bed("Pumpkin Patch", 1000, garden0);
        bedRepository.save(bed01);
        Bed bed10 = new Bed("Vegetable Patch", 1000, garden1);
        bedRepository.save(bed10);
        Bed bed11 = new Bed("Spuds", 1000, garden1);
        bedRepository.save(bed11);
        Bed bed20 = new Bed("Seedlings", 1000, garden2);
        bedRepository.save(bed20);
        Bed bed21 = new Bed("MicroGreens", 1000, garden2);
        bedRepository.save(bed21);
        Plant plant01 = new Plant("Rose bush", "Red Fountain", null, "roses", Units.INTEGERS, "2022/8/23", bed00);
        plantRepository.save(plant01);
        Plant plant02 = new Plant("Rose Bush", "French Rose", null, "roses", Units.INTEGERS, "2022/8/23", bed00);
        plantRepository.save(plant02);
        Plant plant03 = new Plant("Pumpkin", "Pumpinus Pumkininus", null, "pumpkins", Units.GRAMS, "2022/8/23", bed01);
        plantRepository.save(plant03);
        Plant plant04 = new Plant("Cauliflowers", "Cruciferous Caulifowerus", null, "caulifowers", Units.GRAMS, "2022/8/23", bed10);
        plantRepository.save(plant04);
        Plant plant05 = new Plant("Main crop", "Potatus Spudicum", null, "spuds", Units.GRAMS, "2022/8/23", bed11);
        plantRepository.save(plant05);
        Plant plant06 = new Plant("Corn", "Corninus of the Cobbibus", null, "corn", Units.CENTIMETERS, "2022/8/23", bed20);
        plantRepository.save(plant06);
        Plant plant07 = new Plant("Broccoli", "Broccolus Brocollilicus", null, "broccoli shoots", Units.GRAMS, "2022/8/23", bed21);
        plantRepository.save(plant07);
        Plant plant08 = new Plant("Radish", "Spicucus Redvegicus", null, "Raddish shoots", Units.GRAMS, "2022/8/23", bed21);
        plantRepository.save(plant08);
        Plant plant09 = new Plant("Red Cabbage", "Cabbagicum Cabaragicus", null, "red cabbage shoots", Units.GRAMS, "2022/8/23", bed21);
        plantRepository.save(plant09);
        Plant plant10 = new Plant("Brussel Sprouts", "Brusselus Tasteslikefarticus", null, "brussel sprout shoots", Units.GRAMS, "2022/8/23", bed21);
        plantRepository.save(plant10);
        WaterEvent waterEvent01 = new WaterEvent("2022/8/23 12:30:00", 5, true, plant07);
        waterEventRepository.save(waterEvent01);



    }



}
