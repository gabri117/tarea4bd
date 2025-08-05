package com.gestion_academica_db.gestion_academica_db.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfesorDTO {
    private String codigoProfesor;
    private String nombreCompleto;
    private String correo;
}