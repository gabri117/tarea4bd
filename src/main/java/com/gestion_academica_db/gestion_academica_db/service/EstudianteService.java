package com.gestion_academica_db.gestion_academica_db.service;


import java.util.List;
//import java.util.Optional;

import com.gestion_academica_db.gestion_academica_db.dto.EstudianteDTO;
//import com.gestion_academica_db.gestion_academica_db.entity.Estudiante;

public interface EstudianteService {
    List<EstudianteDTO> listar(String apellidoLike, String nombreLike);
    EstudianteDTO porId(String carnet);
}