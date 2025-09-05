package com.gestion_academica_db.gestion_academica_db.dto;

public class ReporteInscritosPorCicloDTO {
    private String ciclo;
    private Long cantidad;

    public ReporteInscritosPorCicloDTO(String ciclo, Long cantidad) {
        this.ciclo = ciclo;
        this.cantidad = cantidad;
    }
    public String getCiclo() { return ciclo; }
    public Long getCantidad() { return cantidad; }
}
