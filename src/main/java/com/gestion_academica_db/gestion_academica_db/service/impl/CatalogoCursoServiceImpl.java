package com.gestion_academica_db.gestion_academica_db.service.impl;

import com.gestion_academica_db.gestion_academica_db.entity.CatalogoCurso;
import com.gestion_academica_db.gestion_academica_db.repository.CatalogoCursoRepository;
import com.gestion_academica_db.gestion_academica_db.service.CatalogoCursoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogoCursoServiceImpl implements CatalogoCursoService {
    private final CatalogoCursoRepository repo;

    public CatalogoCursoServiceImpl(CatalogoCursoRepository repo) {
        this.repo = repo;
    }

    @Override
    public CatalogoCurso crear(CatalogoCurso c) { return repo.save(c); }
    @Override
    public List<CatalogoCurso> obtenerTodos() { return repo.findAll(); }
    @Override
    public Optional<CatalogoCurso> obtenerPorId(String id) { return repo.findById(id); }
    @Override
    public CatalogoCurso actualizar(String id, CatalogoCurso datos) {
        return repo.findById(id)
            .map(c -> {
                c.setNombre(datos.getNombre());
                c.setCreditos(datos.getCreditos());
                c.setPrerrequisito(datos.getPrerrequisito());
                return repo.save(c);
            }).orElseThrow(() -> new RuntimeException("Curso no encontrado"));
    }
    @Override
    public void eliminar(String id) { repo.deleteById(id); }
}
