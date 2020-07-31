package com.greenfox.orientationexam.repositories;

import com.greenfox.orientationexam.models.Spaceship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpaceshipRepository extends JpaRepository<Spaceship, Long> {
}
