package com.gestion_academica_db.gestion_academica_db.repository;

import com.gestion_academica_db.gestion_academica_db.entity.Estudiante;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, String> {
    List<Estudiante> findByApellidoContainingIgnoreCase(String apellido);
    List<Estudiante> findByNombreContainingIgnoreCase(String nombre);
}