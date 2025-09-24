package com.gymtrack.gymtrackApi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gymtrack.gymtrackApi.dtos.SedeRequestDTO;
import com.gymtrack.gymtrackApi.dtos.SedeResponseDTO;
import com.gymtrack.gymtrackApi.services.SedeServices;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/sedes")
public class SedeController {

    private final SedeServices sedeServices;

    public SedeController(SedeServices sedeServices){
        this.sedeServices=sedeServices;
    }

    // EndPoint para crear una nueva sede (POST)
    @PostMapping
    public ResponseEntity<SedeResponseDTO> CrearNuevaSede(@Valid @RequestBody SedeRequestDTO sedeRequestDTO) {
        SedeResponseDTO nuevaSede = sedeServices.CrearSede(sedeRequestDTO);
        return new ResponseEntity<>(nuevaSede, HttpStatus.CREATED);
    }

    // EndPoint  para leer todas las sedes (GET)
    @GetMapping
    public ResponseEntity<List<SedeResponseDTO>> ObtenerSedes(){
        List<SedeResponseDTO> sedes = sedeServices.ObtenerTodasLasSedes();
        return ResponseEntity.ok(sedes);
    }
    
    @GetMapping("/hola") // ->/api/sedes/hola
    public String decirHola() {
        return "Hola desde GymTrack";
    }
    
}
