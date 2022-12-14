package com.example.grow_at_home_server.components;

import com.example.grow_at_home_server.models.*;
import com.example.grow_at_home_server.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

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
        Bed bed00 = new Bed("Rose Bed", 0, garden0);
        bedRepository.save(bed00);
        Bed bed01 = new Bed("Pumpkin Patch", 0, garden0);
        bedRepository.save(bed01);
        Bed bed10 = new Bed("Vegetable Patch", 0, garden1);
        bedRepository.save(bed10);
        Bed bed11 = new Bed("Spuds", 0, garden1);
        bedRepository.save(bed11);
        Bed bed20 = new Bed("Seedlings", 1000, garden2);
        bedRepository.save(bed20);
        Bed bed21 = new Bed("Salads", 1000, garden2);
        bedRepository.save(bed21);
        Plant plant01 = new Plant("Rose bush", "Red Fountain", null, "roses", Units.INTEGERS, "2022-8-23", bed00);
        plantRepository.save(plant01);
        Plant plant02 = new Plant("Rose Bush", "French Rose", null, "roses", Units.INTEGERS, "2022-8-23", bed00);
        plantRepository.save(plant02);
        Plant plant03 = new Plant("Pumpkin", "Pumpinus Pumkininus", null, "pumpkins", Units.GRAMS, "2022-8-23", bed01);
        plantRepository.save(plant03);
        Plant plant04 = new Plant("Cauliflowers", "Cruciferous Caulifowerus", null, "caulifowers", Units.GRAMS, "2022-8-23", bed10);
        plantRepository.save(plant04);
        Plant plant05 = new Plant("Main crop", "Potatus Spudicum", null, "spuds", Units.GRAMS, "2022-8-23", bed11);
        plantRepository.save(plant05);
        Plant plant06 = new Plant("Corn", "Corninus of the Cobbibus", null, "corn", Units.CENTIMETERS, "2022-8-23", bed20);
        plantRepository.save(plant06);
        Plant plant11 = new Plant("Red Onions", "Onnionus Onnunaricus", null, "onions", Units.INTEGERS, "2022-8-23", bed20);
        plantRepository.save(plant11);
        Plant plant12 = new Plant("Red Chillis", "Muchos Spicicus", null, "chillies", Units.INTEGERS, "2022-8-23", bed20);
        plantRepository.save(plant12);
        Plant plant13 = new Plant("Cauliflower", "Whitus Brocolus", null, "caulifower", Units.INTEGERS, "2022-8-23", bed20);
        plantRepository.save(plant13);


        Plant plant07 = new Plant("Broccoli", "Broccolus Brocollilicus", null, "broccoli shoots", Units.GRAMS, "2022-8-23", bed21);
        Plant plant08 = new Plant("Radish", "Spicucus Redvegicus", null, "Raddish shoots", Units.GRAMS, "2022-8-23", bed21);
        Plant plant09 = new Plant("Red Cabbage", "Cabbagicum Cabaragicus", null, "red cabbage shoots", Units.GRAMS, "2022-8-23", bed21);
        Plant plant10 = new Plant("Brussel Sprouts", "Brusselus Tasteslikefarticus", null, "brussel sprout shoots", Units.GRAMS, "2022-8-23", bed21);

        WaterEvent waterEvent00 = new WaterEvent("2022-8-23 02:30:00", 5, true, plant07, 7L);
        plant07.addWaterEvent(waterEvent00);

        WaterEvent waterEvent01 = new WaterEvent("2022-8-23 08:00:00", 5, true, plant07, 7L);
        plant07.addWaterEvent(waterEvent01);
        WaterEvent waterEvent02 = new WaterEvent("2022-8-23 14:00:00", 5, true, plant07, 7L);
        plant07.addWaterEvent(waterEvent02);
        WaterEvent waterEvent03 = new WaterEvent("2022-8-23 20:30:00", 5, true, plant07, 7L);
        plant07.addWaterEvent(waterEvent03);

        WaterEvent waterEvent04 = new WaterEvent("2022-8-24 02:30:00", 5, true, plant07, 7L);
        plant07.addWaterEvent(waterEvent04);
        WaterEvent waterEvent05 = new WaterEvent("2022-8-24 08:00:00", 5, true, plant07, 7L);
        plant07.addWaterEvent(waterEvent05);
        WaterEvent waterEvent06 = new WaterEvent("2022-8-24 14:00:00", 5, true, plant07, 7L);
        plant07.addWaterEvent(waterEvent06);
        WaterEvent waterEvent07 = new WaterEvent("2022-8-24 20:30:00", 5, true, plant07, 7L);
        plant07.addWaterEvent(waterEvent07);

        WaterEvent waterEvent08 = new WaterEvent("2022-8-25 02:30:00", 5, true, plant07, 7L);
        plant07.addWaterEvent(waterEvent08);
        WaterEvent waterEvent09 = new WaterEvent("2022-8-25 08:00:00", 5, true, plant07, 7L);
        plant07.addWaterEvent(waterEvent09);
        WaterEvent waterEvent10 = new WaterEvent("2022-8-25 14:00:00", 5, true, plant07, 7L);
        plant07.addWaterEvent(waterEvent10);
        WaterEvent waterEvent11 = new WaterEvent("2022-8-25 20:30:00", 5, true, plant07, 7L);
        plant07.addWaterEvent(waterEvent11);

        WaterEvent waterEvent12 = new WaterEvent("2022-8-26 02:30:00", 5, true, plant07, 7L);
        plant07.addWaterEvent(waterEvent12);
        WaterEvent waterEvent13 = new WaterEvent("2022-8-26 08:00:00", 5, true, plant07, 7L);
        plant07.addWaterEvent(waterEvent13);
        WaterEvent waterEvent14 = new WaterEvent("2022-8-26 14:00:00", 5, true, plant07, 7L);
        plant07.addWaterEvent(waterEvent14);
        WaterEvent waterEvent15 = new WaterEvent("2022-8-26 20:30:00", 5, true, plant07, 7L);
        plant07.addWaterEvent(waterEvent15);
        plant07.generateAverageWaterInterval();
        plantRepository.save(plant07);
        waterEventRepository.save(waterEvent00);
        waterEventRepository.save(waterEvent01);
        waterEventRepository.save(waterEvent02);
        waterEventRepository.save(waterEvent03);
        waterEventRepository.save(waterEvent04);
        waterEventRepository.save(waterEvent05);
        waterEventRepository.save(waterEvent06);
        waterEventRepository.save(waterEvent07);
        waterEventRepository.save(waterEvent08);
        waterEventRepository.save(waterEvent09);
        waterEventRepository.save(waterEvent10);
        waterEventRepository.save(waterEvent11);
        waterEventRepository.save(waterEvent12);
        waterEventRepository.save(waterEvent13);
        waterEventRepository.save(waterEvent14);
        waterEventRepository.save(waterEvent15);

        WaterEvent waterEvent16 = new WaterEvent("2022-8-23 02:30:00", 5, true, plant08, 8L);
        plant08.addWaterEvent(waterEvent16);
        WaterEvent waterEvent17 = new WaterEvent("2022-8-23 10:30:00", 5, true, plant08, 8L);
        plant08.addWaterEvent(waterEvent17);
        WaterEvent waterEvent18 = new WaterEvent("2022-8-23 18:30:00", 5, true, plant08, 8L);
        plant08.addWaterEvent(waterEvent18);

        WaterEvent waterEvent19 = new WaterEvent("2022-8-24 02:30:00", 5, true, plant08, 8L);
        plant08.addWaterEvent(waterEvent19);
        WaterEvent waterEvent20 = new WaterEvent("2022-8-24 10:30:00", 5, true, plant08, 8L);
        plant08.addWaterEvent(waterEvent20);
        WaterEvent waterEvent21 = new WaterEvent("2022-8-24 18:30:00", 5, true, plant08, 8L);
        plant08.addWaterEvent(waterEvent21);

        WaterEvent waterEvent22 = new WaterEvent("2022-8-25 02:30:00", 5, true, plant08, 8L);
        plant08.addWaterEvent(waterEvent22);
        WaterEvent waterEvent23 = new WaterEvent("2022-8-25 10:30:00", 5, true, plant08, 8L);
        plant08.addWaterEvent(waterEvent23);
        WaterEvent waterEvent24 = new WaterEvent("2022-8-25 18:30:00", 5, true, plant08, 8L);
        plant08.addWaterEvent(waterEvent24);

        WaterEvent waterEvent25 = new WaterEvent("2022-8-26 02:30:00", 5, true, plant08, 8L);
        plant08.addWaterEvent(waterEvent25);
        WaterEvent waterEvent26 = new WaterEvent("2022-8-26 10:30:00", 5, true, plant08, 8L);
        plant08.addWaterEvent(waterEvent26);
        WaterEvent waterEvent27 = new WaterEvent("2022-8-26 18:30:00", 5, true, plant08, 8L);
        plant08.addWaterEvent(waterEvent27);
        plant08.generateAverageWaterInterval();
        plantRepository.save(plant08);
        waterEventRepository.save(waterEvent16);
        waterEventRepository.save(waterEvent17);
        waterEventRepository.save(waterEvent18);
        waterEventRepository.save(waterEvent19);
        waterEventRepository.save(waterEvent20);
        waterEventRepository.save(waterEvent21);
        waterEventRepository.save(waterEvent22);
        waterEventRepository.save(waterEvent23);
        waterEventRepository.save(waterEvent24);
        waterEventRepository.save(waterEvent25);
        waterEventRepository.save(waterEvent26);
        waterEventRepository.save(waterEvent27);




        WaterEvent waterEvent28 = new WaterEvent("2022-8-23 02:30:00", 5, true, plant09, 9L);
        plant09.addWaterEvent(waterEvent28);
        WaterEvent waterEvent29 = new WaterEvent("2022-8-23 12:30:00", 5, true, plant09, 9L);
        plant09.addWaterEvent(waterEvent29);

        WaterEvent waterEvent30 = new WaterEvent("2022-8-24 02:30:00", 5, true, plant09, 9L);
        plant09.addWaterEvent(waterEvent30);
        WaterEvent waterEvent31 = new WaterEvent("2022-8-24 12:30:00", 5, true, plant09, 9L);
        plant09.addWaterEvent(waterEvent31);

        WaterEvent waterEvent32 = new WaterEvent("2022-8-25 02:30:00", 5, true, plant09, 9L);
        plant09.addWaterEvent(waterEvent32);
        WaterEvent waterEvent33 = new WaterEvent("2022-8-25 12:30:00", 5, true, plant09, 9L);
        plant09.addWaterEvent(waterEvent33);

        WaterEvent waterEvent34 = new WaterEvent("2022-8-26 02:30:00", 5, true, plant09, 9L);
        plant09.addWaterEvent(waterEvent34);
        WaterEvent waterEvent35 = new WaterEvent("2022-8-26 12:30:00", 5, true, plant09, 9L);
        plant09.addWaterEvent(waterEvent35);
        plant09.generateAverageWaterInterval();
        plantRepository.save(plant09);
        waterEventRepository.save(waterEvent28);
        waterEventRepository.save(waterEvent29);
        waterEventRepository.save(waterEvent30);
        waterEventRepository.save(waterEvent31);
        waterEventRepository.save(waterEvent32);
        waterEventRepository.save(waterEvent33);
        waterEventRepository.save(waterEvent34);
        waterEventRepository.save(waterEvent35);



        WaterEvent waterEvent36 = new WaterEvent("2022-8-23 02:30:00", 5, true, plant10, 10L);
        plant10.addWaterEvent(waterEvent36);

        WaterEvent waterEvent37 = new WaterEvent("2022-8-24 02:30:00", 5, true, plant10, 10L);
        plant10.addWaterEvent(waterEvent37);

        WaterEvent waterEvent38 = new WaterEvent("2022-8-25 02:30:00", 5, true, plant10, 10L);
        plant10.addWaterEvent(waterEvent38);

        WaterEvent waterEvent39 = new WaterEvent("2022-8-26 02:30:00", 5, true, plant10, 10L);
        plant10.addWaterEvent(waterEvent39);
        plant10.generateAverageWaterInterval();
        plantRepository.save(plant10);
        waterEventRepository.save(waterEvent36);
        waterEventRepository.save(waterEvent37);
        waterEventRepository.save(waterEvent38);
        waterEventRepository.save(waterEvent39);

        Harvest harvest01 = new Harvest("2022-8-25", 5, plant07);
        harvestRepository.save(harvest01);

        WaterSensorReservoirEvent waterSensorReservoirEvent01 = new WaterSensorReservoirEvent("2020-8-23 02:01:00", true,  bed21, 6L);
        waterSensorReservoirEventRepository.save(waterSensorReservoirEvent01);

        WaterSensorReservoirEvent waterSensorReservoirEvent02 = new WaterSensorReservoirEvent("2020-8-24 02:00:00", false,  bed21, 6L);
        waterSensorReservoirEventRepository.save(waterSensorReservoirEvent02);
        WaterSensorReservoirEvent waterSensorReservoirEvent03 = new WaterSensorReservoirEvent("2020-8-24 02:01:00", true,  bed21, 6L);
        waterSensorReservoirEventRepository.save(waterSensorReservoirEvent03);

        WaterSensorReservoirEvent waterSensorReservoirEvent04 = new WaterSensorReservoirEvent("2020-8-25 02:00:00", false,  bed21, 6L);
        waterSensorReservoirEventRepository.save(waterSensorReservoirEvent04);
        WaterSensorReservoirEvent waterSensorReservoirEvent05 = new WaterSensorReservoirEvent("2020-8-25 02:01:00", true,  bed21, 6L);
        waterSensorReservoirEventRepository.save(waterSensorReservoirEvent05);

        WaterSensorReservoirEvent waterSensorReservoirEvent06 = new WaterSensorReservoirEvent("2020-8-26 02:00:00", false,  bed21, 6L);
        waterSensorReservoirEventRepository.save(waterSensorReservoirEvent06);
        WaterSensorReservoirEvent waterSensorReservoirEvent07 = new WaterSensorReservoirEvent("2020-8-26 02:01:00", true,  bed21, 6L);
        waterSensorReservoirEventRepository.save(waterSensorReservoirEvent07);

        WaterSensorReservoirEvent waterSensorReservoirEvent08 = new WaterSensorReservoirEvent("2020-8-26 02:01:00", true,  bed20, 5L);
        waterSensorReservoirEventRepository.save(waterSensorReservoirEvent08);





    }



}
