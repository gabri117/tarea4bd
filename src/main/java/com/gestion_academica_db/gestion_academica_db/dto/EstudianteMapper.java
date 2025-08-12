package com.gestion_academica_db.gestion_academica_db.dto;

import com.gestion_academica_db.gestion_academica_db.entity.Estudiante;

import java.time.LocalDate;
import java.time.Period;

public class EstudianteMapper {

    private static Integer calcularEdad(LocalDate fechaNacimiento) {
        return fechaNacimiento != null ? Period.between(fechaNacimiento, LocalDate.now()).getYears() : null;
    }

    public static EstudianteDTO toDTO(Estudiante entity) {
        if (entity == null) return null;
        EstudianteDTO dto = new EstudianteDTO();
        dto.setCarnet(entity.getCarnet());
        dto.setNombre(entity.getNombre());
        dto.setApellido(entity.getApellido());
        dto.setEdad(calcularEdad(entity.getFechaNacimiento())); 
        return dto;
    }

    public static Estudiante toEntity(EstudianteDTO dto) {
        if (dto == null) return null;
       
        return new Estudiante(
                dto.getCarnet(),
                dto.getNombre(),
                dto.getApellido(),
                null // No se puede calcular la fecha de nacimiento desde la edad, se debe manejar en otro lugar
        );
    }
}
