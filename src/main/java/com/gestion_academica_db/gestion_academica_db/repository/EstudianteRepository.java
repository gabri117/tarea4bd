package com.gestion_academica_db.gestion_academica_db.repository;

import com.gestion_academica_db.gestion_academica_db.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, String> {}
