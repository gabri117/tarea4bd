package com.gestion_academica_db.gestion_academica_db.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "profesor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profesor {
    @Id
    @Column(name = "codigo_profesor", length = 10)
    private String codigoProfesor;

    @Column(name = "nombre_completo", nullable = false, length = 100)
    private String nombreCompleto;

    @Column(nullable = false, length = 100)
    private String correo;
}