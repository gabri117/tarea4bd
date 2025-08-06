package com.gestion_academica_db.gestion_academica_db.dto;

import com.gestion_academica_db.gestion_academica_db.entity.Profesor;

public class ProfesorMapper {
    public static ProfesorDTO toDTO(Profesor entity) {
        if (entity == null) return null;
        return new ProfesorDTO(
                entity.getCodigoProfesor(),
                entity.getNombreCompleto(),
                entity.getCorreo()
        );
    }

    public static Profesor toEntity(ProfesorDTO dto) {
        if (dto == null) return null;
        return new Profesor(
                dto.getCodigoProfesor(),
                dto.getNombreCompleto(),
                dto.getCorreo()
        );
    }
}