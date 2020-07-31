package com.greenfox.orientationexam.controllers;

import com.greenfox.orientationexam.services.TransportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
