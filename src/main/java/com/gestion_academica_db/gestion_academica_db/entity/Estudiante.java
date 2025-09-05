package com.gestion_academica_db.gestion_academica_db.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "estudiante")
@Data @NoArgsConstructor @AllArgsConstructor
public class Estudiante {

    @Id
    @Column(name = "carnet", length = 15)
    private String carnet;

    @Column(name = "nombre", nullable = false, length = 40)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 40)
    private String apellido;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;
}
