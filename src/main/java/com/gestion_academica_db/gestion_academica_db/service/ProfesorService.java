package com.gestion_academica_db.gestion_academica_db.service;

import com.gestion_academica_db.gestion_academica_db.entity.Profesor;
import com.gestion_academica_db.gestion_academica_db.repository.ProfesorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {
    private final ProfesorRepository repo;

    public ProfesorService(ProfesorRepository repo) {
        this.repo = repo;
    }

    public Profesor crear(Profesor p) { return repo.save(p); }
    public List<Profesor> obtenerTodos() { return repo.findAll(); }
    public Optional<Profesor> obtenerPorId(String id) { return repo.findById(id); }
    public Profesor actualizar(String id, Profesor datos) {
        return repo.findById(id)
            .map(p -> {
                p.setNombreCompleto(datos.getNombreCompleto());
                p.setCorreo(datos.getCorreo());
                return repo.save(p);
            }).orElseThrow(() -> new RuntimeException("Profesor no encontrado"));
    }
    public void eliminar(String id) { repo.deleteById(id); }
}