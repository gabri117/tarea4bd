package com.gestion_academica_db.gestion_academica_db.service;

import com.gestion_academica_db.gestion_academica_db.entity.Profesor;

import java.util.List;
import java.util.Optional;

public interface ProfesorService {
    Profesor crear(Profesor p);
    List<Profesor> obtenerTodos();
    Optional<Profesor> obtenerPorId(String id);
    Profesor actualizar(String id, Profesor datos);
    void eliminar(String id);
}