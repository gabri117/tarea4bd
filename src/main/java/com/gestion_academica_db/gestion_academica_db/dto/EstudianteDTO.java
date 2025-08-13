package com.gestion_academica_db.gestion_academica_db.dto;

import lombok.*;
//import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteDTO {
    private String carnet;
    private String nombre;
    private String apellido;
    private Integer edad; // <------- en lugar de fechaNacimiento
}