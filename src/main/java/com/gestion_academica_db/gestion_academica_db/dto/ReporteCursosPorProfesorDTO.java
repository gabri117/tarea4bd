package com.gestion_academica_db.gestion_academica_db.dto;

public class ReporteCursosPorProfesorDTO {
    private String nombreProfesor;
    private Long cantidadCursos;

    public ReporteCursosPorProfesorDTO(String nombreProfesor, Long cantidadCursos) {
        this.nombreProfesor = nombreProfesor;
        this.cantidadCursos = cantidadCursos;
    }
    public String getNombreProfesor() { return nombreProfesor; }
    public Long getCantidadCursos() { return cantidadCursos; }
}
