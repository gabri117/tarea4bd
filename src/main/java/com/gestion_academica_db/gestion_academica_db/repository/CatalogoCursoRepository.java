package com.gestion_academica_db.gestion_academica_db.repository;

import com.gestion_academica_db.gestion_academica_db.entity.CatalogoCurso;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogoCursoRepository extends JpaRepository<CatalogoCurso, String> {
    List<CatalogoCurso> findByNombreContainingIgnoreCase(String nombre);
    List<CatalogoCurso> findByCreditosGreaterThanEqual(Integer creditos);
}