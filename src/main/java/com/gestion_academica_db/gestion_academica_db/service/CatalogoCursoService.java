package com.gestion_academica_db.gestion_academica_db.service;

import com.gestion_academica_db.gestion_academica_db.entity.CatalogoCurso;
import com.gestion_academica_db.gestion_academica_db.repository.CatalogoCursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogoCursoService {
    private final CatalogoCursoRepository repo;

    public CatalogoCursoService(CatalogoCursoRepository repo) {
        this.repo = repo;
    }

    public CatalogoCurso crear(CatalogoCurso c) { return repo.save(c); }
    public List<CatalogoCurso> obtenerTodos() { return repo.findAll(); }
    public Optional<CatalogoCurso> obtenerPorId(String id) { return repo.findById(id); }
    public CatalogoCurso actualizar(String id, CatalogoCurso datos) {
        return repo.findById(id)
            .map(c -> {
                c.setNombre(datos.getNombre());
                c.setCreditos(datos.getCreditos());
                c.setPrerrequisito(datos.getPrerrequisito());
                return repo.save(c);
            }).orElseThrow(() -> new RuntimeException("Curso no encontrado"));
    }
    public void eliminar(String id) { repo.deleteById(id); }
}