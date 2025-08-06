package com.gestion_academica_db.gestion_academica_db.service.impl;

import com.gestion_academica_db.gestion_academica_db.entity.Estudiante;
import com.gestion_academica_db.gestion_academica_db.repository.EstudianteRepository;
import com.gestion_academica_db.gestion_academica_db.service.EstudianteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServiceImpl implements EstudianteService {
    private final EstudianteRepository repo;

    public EstudianteServiceImpl(EstudianteRepository repo) {
        this.repo = repo;
    }

    @Override
    public Estudiante crear(Estudiante e) { return repo.save(e); }
    @Override
    public List<Estudiante> obtenerTodos() { return repo.findAll(); }
    @Override
    public Optional<Estudiante> obtenerPorId(String id) { return repo.findById(id); }
    @Override
    public Estudiante actualizar(String id, Estudiante datos) {
        return repo.findById(id)
            .map(e -> {
                e.setNombre(datos.getNombre());
                e.setApellido(datos.getApellido());
                e.setFechaNacimiento(datos.getFechaNacimiento());
                return repo.save(e);
            }).orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }
    @Override
    public void eliminar(String id) { repo.deleteById(id); }
}