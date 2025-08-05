package com.gestion_academica_db.gestion_academica_db.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "catalogo_curso")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogoCurso {
    @Id
    @Column(name = "codigo_curso", length = 10)
    private String codigoCurso;

    @Column(nullable = false, length = 80)
    private String nombre;

    @Column(nullable = false)
    private Integer creditos;

    @ManyToOne
    @JoinColumn(name = "codigo_prerrequisito")
    private CatalogoCurso prerrequisito; // auto-relación opcional
}