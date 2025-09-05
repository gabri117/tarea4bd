package com.gestion_academica_db.gestion_academica_db.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "curso_programado")
@Data @NoArgsConstructor @AllArgsConstructor
public class CursoProgramado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso_programado")
    private Integer idCursoProgramado;

    @ManyToOne(optional = false)
    @JoinColumn(name = "codigo_curso", referencedColumnName = "codigo_curso", nullable = false)
    private CatalogoCurso curso;

    @Column(name = "semestre", nullable = false)
    private Integer semestre;

    @Column(name = "ciclo", nullable = false)
    private Integer ciclo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "codigo_profesor", referencedColumnName = "codigo_profesor", nullable = false)
    private Profesor profesor;
}
