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

    @Override
    public boolean moveSpaceShip(Long id) {
        Spaceship spaceship = getSpaceship().get(0);
        if (spaceship.getPlanet_id() == id){
            return true;
        }
        spaceship.setPlanet_id(id);
        this.spaceshipRepository.save(spaceship);
        return false;
    }

    @Override
    public void movePoepleToPlanet(Long id) {
        Long numberOfMovingPeople;
        Spaceship spaceship = getSpaceship().get(0);
        numberOfMovingPeople = spaceship.getUtilization();
        spaceship.setUtilization(0L);
        this.spaceshipRepository.save(spaceship);

        Planet planet = this.planetRepository.getOne(id);
        planet.setPopulation(planet.getPopulation() + numberOfMovingPeople);
        this.planetRepository.save(planet);
    }

    @Override
    public void movePoepleToShip(Long id) {
        Spaceship spaceship = getSpaceship().get(0);
        Long maxPeopleToBeTrasnported = spaceship.getMax_capacity() - spaceship.getUtilization();

        Planet planet = this.planetRepository.getOne(id);
        if(planet.getPopulation() > maxPeopleToBeTrasnported){
            spaceship.setUtilization(spaceship.getUtilization() + maxPeopleToBeTrasnported);
            planet.setPopulation(planet.getPopulation() - maxPeopleToBeTrasnported);
        }
        else if(planet.getPopulation() <= maxPeopleToBeTrasnported){
            spaceship.setUtilization(spaceship.getUtilization() + planet.getPopulation());
            planet.setPopulation(0L);
        }
        this.planetRepository.save(planet);
        this.spaceshipRepository.save(spaceship);
    }
}
