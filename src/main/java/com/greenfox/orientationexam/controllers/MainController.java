package com.greenfox.orientationexam.controllers;

import com.greenfox.orientationexam.services.TransportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

    private TransportService transportService;

    public MainController(TransportService transportService) {
        this.transportService = transportService;
    }

    @GetMapping("/")
    public String showMainScreen(Model model){
        model.addAttribute("planets", transportService.getPlanets());
        model.addAttribute("spaceship", transportService.getSpaceship().get(0));
        return "main";
    }

    @GetMapping("/movehere/{id}")
    public String moveSpaceShip(Model model, @PathVariable Long id){
        if(transportService.moveSpaceShip(id)){
            model.addAttribute("error", true);
        }
        else {
            model.addAttribute("error", false);
        }
        model.addAttribute("planets", transportService.getPlanets());
        model.addAttribute("spaceship", transportService.getSpaceship().get(0));
        return "main";
    }

    @GetMapping("/toplanet/{id}")
    public String movetPeopleToPlanet(Model model, @PathVariable Long id){
        transportService.movePoepleToPlanet(id);
        model.addAttribute("planets", transportService.getPlanets());
        model.addAttribute("spaceship", transportService.getSpaceship().get(0));
        return "main";
    }

    @GetMapping("/toship/{id}")
    public String movetPeopleToShip(Model model, @PathVariable Long id){
        transportService.movePoepleToShip(id);
        model.addAttribute("planets", transportService.getPlanets());
        model.addAttribute("spaceship", transportService.getSpaceship().get(0));
        return "main";
    }


}
