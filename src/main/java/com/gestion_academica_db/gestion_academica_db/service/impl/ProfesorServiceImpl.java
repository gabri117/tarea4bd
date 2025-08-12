package com.gestion_academica_db.gestion_academica_db.service.impl;

import com.gestion_academica_db.gestion_academica_db.dto.ProfesorDTO;
import com.gestion_academica_db.gestion_academica_db.entity.Profesor;
import com.gestion_academica_db.gestion_academica_db.repository.ProfesorRepository;
import com.gestion_academica_db.gestion_academica_db.service.ProfesorService;
import org.springframework.stereotype.Service;

import java.util.List;
//import java.util.Optional;

@Service
public class ProfesorServiceImpl implements ProfesorService {
    private final ProfesorRepository repo;

    public ProfesorServiceImpl(ProfesorRepository repo) { this.repo = repo; }

    private ProfesorDTO toDTO(Profesor p) {
        return new ProfesorDTO(p.getCodigoProfesor(), p.getNombreCompleto(), p.getCorreo());
    }

    @Override
    public List<ProfesorDTO> listar(String nombreLike) {
        List<Profesor> data = (nombreLike == null || nombreLike.isBlank())
                ? repo.findAll()
                : repo.findByNombreCompletoContainingIgnoreCase(nombreLike);
        return data.stream().map(this::toDTO).toList();
    }

    @Override
    public ProfesorDTO porId(String id) {
        return repo.findById(id).map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));
    }
}