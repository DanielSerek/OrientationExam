package com.greenfox.orientationexam.services;

import com.greenfox.orientationexam.models.Planet;
import com.greenfox.orientationexam.models.Spaceship;

import java.util.List;

public interface TransportService {

    List<Planet> getPlanets();

    List<Spaceship> getSpaceship();

    boolean moveSpaceShip(Long id);

    void movePoepleToPlanet(Long id);

    void movePoepleToShip(Long id);
}
