package com.gymtrack.gymtrackApi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gymtrack.gymtrackApi.dtos.SedeRequestDTO;
import com.gymtrack.gymtrackApi.dtos.SedeResponseDTO;
import com.gymtrack.gymtrackApi.entities.Sede;
import com.gymtrack.gymtrackApi.repositories.SedeRepository;

@Service //indica la logica del negocio
public class SedeServices {
    
    private final SedeRepository sedeRepository;

    // Inyeccion de despendencias por constructor 
    public SedeServices(SedeRepository sedeRepository){
        this.sedeRepository = sedeRepository;
    }

    // metodos para crear una nueva sede
    public SedeResponseDTO CrearSede(SedeRequestDTO sedeRequestDTO){
        // 1. convertir el DTO de entrada a una entidad sede.
        Sede nuevaSede = new Sede();
        nuevaSede.setNombre_sede(sedeRequestDTO.getNombre_sede());
        nuevaSede.setDireccion(sedeRequestDTO.getDireccion());
        nuevaSede.setTelefono(sedeRequestDTO.getTelefono());

        // 2. Guardamos la entidad en la base de datos.
        Sede sedeGuardada = sedeRepository.save(nuevaSede);

        // 3. convertimos la entidad guardada en la base de datos
        return convertir_A_DTO(sedeGuardada);
    }

    // Metodo para obtener todas las sedes 
    public List<SedeResponseDTO> ObtenerTodasLasSedes(){
        // 1. Obtenemos la lista de todas las entidades sede.
        List<Sede> sedes = sedeRepository.findAll();

        // 2. Convertimos cada entidad de la lista a su DTO Correspondiente.
        return sedes.stream()
                .map(this::convertir_A_DTO)
                .collect(Collectors.toList());
    }

    // Metodo privado para reutilizar la logica de conversion
    private SedeResponseDTO convertir_A_DTO(Sede sede){
        SedeResponseDTO dto = new SedeResponseDTO();
        dto.setId(sede.getId());
        dto.setNombre_sede(sede.getNombre_sede());
        dto.setDireccion(sede.getDireccion());
        dto.setTelefono(sede.getTelefono());

        return dto;
    }
}
