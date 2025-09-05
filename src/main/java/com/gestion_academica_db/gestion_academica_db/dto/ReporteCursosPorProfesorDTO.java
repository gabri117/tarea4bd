package com.gestion_academica_db.gestion_academica_db.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ReporteCursosPorProfesorDTO {
    private String nombreProfesor; // p.nombreCompleto
    private Long cantidadCursos;   // COUNT(cp)
}
