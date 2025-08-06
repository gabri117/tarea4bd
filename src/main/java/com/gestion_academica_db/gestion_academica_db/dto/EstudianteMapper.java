package com.gestion_academica_db.gestion_academica_db.dto;

import com.gestion_academica_db.gestion_academica_db.entity.Estudiante;

public class EstudianteMapper {
    public static EstudianteDTO toDTO(Estudiante entity) {
        if (entity == null) return null;
        return new EstudianteDTO(
                entity.getCarnet(),
                entity.getNombre(),
                entity.getApellido(),
                entity.getFechaNacimiento()
        );
    }

    public static Estudiante toEntity(EstudianteDTO dto) {
        if (dto == null) return null;
        return new Estudiante(
                dto.getCarnet(),
                dto.getNombre(),
                dto.getApellido(),
                dto.getFechaNacimiento()
        );
    }
}
