package com.gestion_academica_db.gestion_academica_db.repository;

import com.gestion_academica_db.gestion_academica_db.entity.Profesor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, String> {
    List<Profesor> findByNombreCompletoContainingIgnoreCase(String nombre);
}