package com.gestion_academica_db.gestion_academica_db.repository;

import com.gestion_academica_db.gestion_academica_db.dto.*;
import com.gestion_academica_db.gestion_academica_db.entity.Inscripcion;
import com.gestion_academica_db.gestion_academica_db.entity.InscripcionId;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InscripcionRepository extends JpaRepository<Inscripcion, InscripcionId> {

    @Query("""
        SELECT new com.gestion_academica_db.gestion_academica_db.dto.ReportePromedioPorCursoDTO(
            cp.curso.nombre,
            AVG(i.notaFinal)
        )
        FROM Inscripcion i
        JOIN i.cursoProgramado cp
        GROUP BY cp.curso.nombre
        ORDER BY cp.curso.nombre ASC
    """)
    List<ReportePromedioPorCursoDTO> promedioPorCurso();

    @Query("""
        SELECT new com.gestion_academica_db.gestion_academica_db.dto.ReporteInscritosPorCicloDTO(
            cp.ciclo,
            COUNT(i)
        )
        FROM Inscripcion i
        JOIN i.cursoProgramado cp
        GROUP BY cp.ciclo
        ORDER BY cp.ciclo ASC
    """)
    List<ReporteInscritosPorCicloDTO> inscritosPorCiclo();

    @Query("""
        SELECT new com.gestion_academica_db.gestion_academica_db.dto.ReporteTopCursoPromedioDTO(
            cp.curso.nombre,
            AVG(i.notaFinal)
        )
        FROM Inscripcion i
        JOIN i.cursoProgramado cp
        GROUP BY cp.curso.nombre
        ORDER BY AVG(i.notaFinal) DESC
    """)
    List<ReporteTopCursoPromedioDTO> topCursosPorPromedio(Pageable pageable);
}
