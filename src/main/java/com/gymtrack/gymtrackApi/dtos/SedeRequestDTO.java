package com.gymtrack.gymtrackApi.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SedeRequestDTO {
    
    @NotBlank(message = "El nombre de la sede no puede estar vacío.")
    private String nombre_sede;
    
    @NotBlank(message = "La dirección de la sede no puede estar vacía.")
    private String direccion;

    private String telefono;
}
