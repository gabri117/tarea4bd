package com.gestion_academica_db.gestion_academica_db.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data @NoArgsConstructor @AllArgsConstructor
public class InscripcionId implements Serializable {
    @Column(name = "carnet", length = 15)
    private String carnet;

    @Column(name = "id_curso_programado")
    private Integer idCursoProgramado;
}
