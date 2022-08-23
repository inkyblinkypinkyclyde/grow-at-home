package com.example.grow_at_home_server.repository;

import com.example.grow_at_home_server.models.Bed;
import com.example.grow_at_home_server.models.Garden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GardenRepository extends JpaRepository<Garden, Long> {
}
