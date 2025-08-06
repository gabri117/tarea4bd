package com.gestion_academica_db.gestion_academica_db.service;


import java.util.List;
import java.util.Optional;

import com.gestion_academica_db.gestion_academica_db.entity.CatalogoCurso;

public interface CatalogoCursoService {
    CatalogoCurso crear(CatalogoCurso c);
    List<CatalogoCurso> obtenerTodos();
    Optional<CatalogoCurso> obtenerPorId(String id);
    CatalogoCurso actualizar(String id, CatalogoCurso datos);
    void eliminar(String id);
}