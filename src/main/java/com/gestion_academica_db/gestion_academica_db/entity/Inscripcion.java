package com.gestion_academica_db.gestion_academica_db.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "inscripcion")
public class Inscripcion {

    @EmbeddedId
    private InscripcionId id;

    // Por ahora, deja sin relaciones para compilar;
    // luego lo cambiamos a @MapsId + ManyToOne cuando pegues las otras entidades.
    @Column(name = "nota_final", precision = 4, scale = 2)
    private BigDecimal notaFinal;

    @Column(name = "fecha_evaluacion")
    private LocalDate fechaEvaluacion;

    public InscripcionId getId() { return id; }
    public void setId(InscripcionId id) { this.id = id; }
    public BigDecimal getNotaFinal() { return notaFinal; }
    public void setNotaFinal(BigDecimal notaFinal) { this.notaFinal = notaFinal; }
    public LocalDate getFechaEvaluacion() { return fechaEvaluacion; }
    public void setFechaEvaluacion(LocalDate fechaEvaluacion) { this.fechaEvaluacion = fechaEvaluacion; }
}
