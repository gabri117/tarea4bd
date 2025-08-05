package com.gestion_academica_db.gestion_academica_db.service;

import com.gestion_academica_db.gestion_academica_db.entity.Estudiante;
import com.gestion_academica_db.gestion_academica_db.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {
    private final EstudianteRepository repo;

    public EstudianteService(EstudianteRepository repo) {
        this.repo = repo;
    }

    public Estudiante crear(Estudiante e) { return repo.save(e); }
    public List<Estudiante> obtenerTodos() { return repo.findAll(); }
    public Optional<Estudiante> obtenerPorId(String id) { return repo.findById(id); }
    public Estudiante actualizar(String id, Estudiante datos) {
        return repo.findById(id)
            .map(e -> {
                e.setNombre(datos.getNombre());
                e.setApellido(datos.getApellido());
                e.setFechaNacimiento(datos.getFechaNacimiento());
                return repo.save(e);
            }).orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }
    public void eliminar(String id) { repo.deleteById(id); }
}