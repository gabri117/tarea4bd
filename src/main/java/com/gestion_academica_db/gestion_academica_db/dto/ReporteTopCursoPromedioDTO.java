package com.gestion_academica_db.gestion_academica_db.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ReporteTopCursoPromedioDTO {
    private String nombreCurso; // cp.curso.nombre
    private Double promedio;    // AVG(i.notaFinal) -> Double
}
