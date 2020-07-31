package com.greenfox.orientationexam.repositories;

import com.greenfox.orientationexam.models.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepository extends JpaRepository<Planet, Long> {
}
