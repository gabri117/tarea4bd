package com.gestion_academica_db.gestion_academica_db.service.impl;

import com.gestion_academica_db.gestion_academica_db.dto.EstudianteDTO;
import com.gestion_academica_db.gestion_academica_db.entity.Estudiante;
import com.gestion_academica_db.gestion_academica_db.repository.EstudianteRepository;
import com.gestion_academica_db.gestion_academica_db.service.EstudianteService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
//import java.util.Optional;

@Service
public class EstudianteServiceImpl implements EstudianteService {
    private final EstudianteRepository repo;

    public EstudianteServiceImpl(EstudianteRepository repo) { this.repo = repo; }

    private int calcularEdad(LocalDate nacimiento) {
        return Period.between(nacimiento, LocalDate.now()).getYears();
    }
    private EstudianteDTO toDTO(Estudiante e) {
        return new EstudianteDTO(
                e.getCarnet(), e.getNombre(), e.getApellido(),
                e.getFechaNacimiento() != null ? calcularEdad(e.getFechaNacimiento()) : null
        );
    }

    @Override
    public List<EstudianteDTO> listar(String apellidoLike, String nombreLike) {
        List<Estudiante> data;
        if (apellidoLike != null && !apellidoLike.isBlank()) {
            data = repo.findByApellidoContainingIgnoreCase(apellidoLike);
        } else if (nombreLike != null && !nombreLike.isBlank()) {
            data = repo.findByNombreContainingIgnoreCase(nombreLike);
        } else {
            data = repo.findAll();
        }
        return data.stream().map(this::toDTO).toList();
    }

    @Override
    public EstudianteDTO porId(String carnet) {
        return repo.findById(carnet).map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }
}
