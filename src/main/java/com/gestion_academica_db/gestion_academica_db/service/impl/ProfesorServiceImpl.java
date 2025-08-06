package com.gestion_academica_db.gestion_academica_db.service.impl;

import com.gestion_academica_db.gestion_academica_db.entity.Profesor;
import com.gestion_academica_db.gestion_academica_db.repository.ProfesorRepository;
import com.gestion_academica_db.gestion_academica_db.service.ProfesorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServiceImpl implements ProfesorService {
    private final ProfesorRepository repo;

    public ProfesorServiceImpl(ProfesorRepository repo) {
        this.repo = repo;
    }

    @Override
    public Profesor crear(Profesor p) { return repo.save(p); }
    @Override
    public List<Profesor> obtenerTodos() { return repo.findAll(); }
    @Override
    public Optional<Profesor> obtenerPorId(String id) { return repo.findById(id); }
    @Override
    public Profesor actualizar(String id, Profesor datos) {
        return repo.findById(id)
            .map(p -> {
                p.setNombreCompleto(datos.getNombreCompleto());
                p.setCorreo(datos.getCorreo());
                return repo.save(p);
            }).orElseThrow(() -> new RuntimeException("Profesor no encontrado"));
    }
    @Override
    public void eliminar(String id) { repo.deleteById(id); }
}