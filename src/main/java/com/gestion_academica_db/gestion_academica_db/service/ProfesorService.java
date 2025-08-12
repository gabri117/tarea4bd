package com.gestion_academica_db.gestion_academica_db.service;

import com.gestion_academica_db.gestion_academica_db.dto.ProfesorDTO;
//import com.gestion_academica_db.gestion_academica_db.entity.Profesor;

import java.util.List;
//import java.util.Optional;

public interface ProfesorService {
    List<ProfesorDTO> listar(String nombreLike);           // filtro opcional
    ProfesorDTO porId(String id);
}