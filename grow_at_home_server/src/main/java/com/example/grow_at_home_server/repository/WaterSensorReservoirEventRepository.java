package com.example.grow_at_home_server.repository;

import com.example.grow_at_home_server.models.WaterSensorReservoirEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterSensorReservoirEventRepository extends JpaRepository<WaterSensorReservoirEvent, Long> {
}
