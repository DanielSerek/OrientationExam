package com.greenfox.orientationexam;

import com.greenfox.orientationexam.repositories.PlanetRepository;
import com.greenfox.orientationexam.repositories.SpaceshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrientationexamApplication implements CommandLineRunner {

    private PlanetRepository planetRepository;
    private SpaceshipRepository spaceshipRepository;

    @Autowired
    public OrientationexamApplication(PlanetRepository planetRepository, SpaceshipRepository spaceshipRepository) {
        this.planetRepository = planetRepository;
        this.spaceshipRepository = spaceshipRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(OrientationexamApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
