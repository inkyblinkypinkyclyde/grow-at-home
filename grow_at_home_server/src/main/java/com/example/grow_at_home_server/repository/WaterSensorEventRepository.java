package com.example.grow_at_home_server.repository;

import com.example.grow_at_home_server.models.WaterSensorEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterSensorEventRepository extends JpaRepository<WaterSensorEvent, Long> {
}
