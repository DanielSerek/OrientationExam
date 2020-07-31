package com.greenfox.orientationexam.services;

import com.greenfox.orientationexam.models.Planet;
import com.greenfox.orientationexam.models.Spaceship;
import com.greenfox.orientationexam.repositories.PlanetRepository;
import com.greenfox.orientationexam.repositories.SpaceshipRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportServiceImpl implements TransportService {

    private PlanetRepository planetRepository;
    private SpaceshipRepository spaceshipRepository;

    public TransportServiceImpl(PlanetRepository planetRepository, SpaceshipRepository spaceshipRepository) {
        this.planetRepository = planetRepository;
        this.spaceshipRepository = spaceshipRepository;
    }

    @Override
    public List<Planet> getPlanets() {
        return this.planetRepository.findAll();
    }

    public List<Spaceship> getSpaceship(){
        return this.spaceshipRepository.findAll();
    }
}
