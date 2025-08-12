package com.gestion_academica_db.gestion_academica_db.service.impl;

import com.gestion_academica_db.gestion_academica_db.dto.CatalogoCursoDTO;
import com.gestion_academica_db.gestion_academica_db.entity.CatalogoCurso;
import com.gestion_academica_db.gestion_academica_db.repository.CatalogoCursoRepository;
import com.gestion_academica_db.gestion_academica_db.service.CatalogoCursoService;
import org.springframework.stereotype.Service;

import java.util.List;
//import java.util.Optional;

@Service
public class CatalogoCursoServiceImpl implements CatalogoCursoService {
    private final CatalogoCursoRepository repo;

    public CatalogoCursoServiceImpl(CatalogoCursoRepository repo) { this.repo = repo; }

    private CatalogoCursoDTO toDTO(CatalogoCurso c) {
        return new CatalogoCursoDTO(
                c.getCodigoCurso(), c.getNombre(), c.getCreditos(),
                c.getPrerrequisito() != null ? c.getPrerrequisito().getCodigoCurso() : null
        );
    }

    @Override
    public List<CatalogoCursoDTO> listar(String nombreLike, Integer creditosMin) {
        List<CatalogoCurso> data;
        if (creditosMin != null) {
            data = repo.findByCreditosGreaterThanEqual(creditosMin);
        } else if (nombreLike != null && !nombreLike.isBlank()) {
            data = repo.findByNombreContainingIgnoreCase(nombreLike);
        } else {
            data = repo.findAll();
        }
        return data.stream().map(this::toDTO).toList();
    }

    @Override
    public CatalogoCursoDTO porId(String codigo) {
        return repo.findById(codigo).map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
    }
}