package com.gestion_academica_db.gestion_academica_db.dto;

public class ReporteTopCursoPromedioDTO {
    private String nombreCurso;
    private Double promedio;

    public ReporteTopCursoPromedioDTO(String nombreCurso, Double promedio) {
        this.nombreCurso = nombreCurso;
        this.promedio = promedio;
    }
    public String getNombreCurso() { return nombreCurso; }
    public Double getPromedio() { return promedio; }
}
