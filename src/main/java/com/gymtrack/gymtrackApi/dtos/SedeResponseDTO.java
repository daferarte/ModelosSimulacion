package com.gymtrack.gymtrackApi.dtos;

import lombok.Data;

@Data
public class SedeResponseDTO {
    private Integer id;
    private String nombre_sede;
    private String direccion;
    private String telefono;
}
