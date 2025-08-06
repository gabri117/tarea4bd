package com.gestion_academica_db.gestion_academica_db.dto;

import com.gestion_academica_db.gestion_academica_db.entity.CatalogoCurso;

public class CatalogoCursoMapper {
    public static CatalogoCursoDTO toDTO(CatalogoCurso entity) {
        if (entity == null) return null;
        return new CatalogoCursoDTO(
                entity.getCodigoCurso(),
                entity.getNombre(),
                entity.getCreditos(),
                entity.getPrerrequisito() != null ? entity.getPrerrequisito().getCodigoCurso() : null
        );
    }

    public static CatalogoCurso toEntity(CatalogoCursoDTO dto, CatalogoCurso prerrequisito) {
        if (dto == null) return null;
        return new CatalogoCurso(
                dto.getCodigoCurso(),
                dto.getNombre(),
                dto.getCreditos(),
                prerrequisito // esto lo resuelve el servicio con un findById(dto.getCodigoPrerrequisito())
        );
    }
}
