package com.gestion_academica_db.gestion_academica_db.service;


import java.util.List;
//import java.util.Optional;

import com.gestion_academica_db.gestion_academica_db.dto.CatalogoCursoDTO;
//import com.gestion_academica_db.gestion_academica_db.entity.CatalogoCurso;

public interface CatalogoCursoService {
    List<CatalogoCursoDTO> listar(String nombreLike, Integer creditosMin);
    CatalogoCursoDTO porId(String codigo);
}