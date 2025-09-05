package com.gestion_academica_db.gestion_academica_db.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "inscripcion")
@Data @NoArgsConstructor @AllArgsConstructor
public class Inscripcion {

    @EmbeddedId
    private InscripcionId id;

    @ManyToOne(optional = false)
    @MapsId("carnet")
    @JoinColumn(name = "carnet", referencedColumnName = "carnet")
    private Estudiante estudiante;

    @ManyToOne(optional = false)
    @MapsId("idCursoProgramado")
    @JoinColumn(name = "id_curso_programado", referencedColumnName = "id_curso_programado")
    private CursoProgramado cursoProgramado;

    @Column(name = "nota_final", precision = 4, scale = 2)
    private BigDecimal notaFinal;

    @Column(name = "fecha_evaluacion")
    private LocalDate fechaEvaluacion;
}
