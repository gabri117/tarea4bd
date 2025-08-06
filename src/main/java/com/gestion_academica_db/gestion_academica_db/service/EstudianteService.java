package com.gestion_academica_db.gestion_academica_db.service;


import java.util.List;
import java.util.Optional;

import com.gestion_academica_db.gestion_academica_db.entity.Estudiante;

public interface EstudianteService {
    Estudiante crear(Estudiante e);
    List<Estudiante> obtenerTodos();
    Optional<Estudiante> obtenerPorId(String id);
    Estudiante actualizar(String id, Estudiante datos);
    void eliminar(String id);
}