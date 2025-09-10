package com.gymtrack.gymtrackApi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/sedes")
public class SedeController {
    @GetMapping("/hola") // ->/api/sedes/hola
    public String decirHola() {
        return "Hola desde GymTrack";
    }
    
}
