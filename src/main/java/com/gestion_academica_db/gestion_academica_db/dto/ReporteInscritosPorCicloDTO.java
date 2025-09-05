package com.gestion_academica_db.gestion_academica_db.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ReporteInscritosPorCicloDTO {
    private Integer ciclo;      // cp.ciclo  -> Integer (tu entidad lo mapea como Integer)
    private Long cantidad;      // COUNT(i)  -> Long
}
