package com.example.grow_at_home_server.repository;

import com.example.grow_at_home_server.models.WaterEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterEventRepository extends JpaRepository<WaterEvent, Long> {

}
