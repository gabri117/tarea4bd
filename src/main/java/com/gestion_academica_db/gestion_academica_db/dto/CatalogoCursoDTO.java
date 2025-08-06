package com.gestion_academica_db.gestion_academica_db.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogoCursoDTO {
    private String codigoCurso;
    private String nombre;
    private Integer creditos;
    private String codigoPrerrequisito; // Solo el código para evitar ciclos y mantener simple el DTO
}