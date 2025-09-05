package com.gestion_academica_db.gestion_academica_db.repository;

import com.gestion_academica_db.gestion_academica_db.dto.*;
import com.gestion_academica_db.gestion_academica_db.entity.Inscripcion;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Integer> {

    // Reporte 2: promedio por curso
    @Query("""
        SELECT new com.gestion_academica_db.gestion_academica_db.dto.ReportePromedioPorCursoDTO(
            cc.nombre,
            AVG(i.notaFinal)
        )
        FROM Inscripcion i
        JOIN CursoProgramado cp ON i.idCursoProgramado = cp.idCursoProgramado
        JOIN CatalogoCurso cc ON cp.codigoCurso = cc.codigoCurso
        GROUP BY cc.nombre
        ORDER BY cc.nombre ASC
    """)
    List<ReportePromedioPorCursoDTO> promedioPorCurso();

    // Reporte 3: inscritos por ciclo
    @Query("""
        SELECT new com.gestion_academica_db.gestion_academica_db.dto.ReporteInscritosPorCicloDTO(
            cp.ciclo,
            COUNT(i.carnet)
        )
        FROM Inscripcion i
        JOIN CursoProgramado cp ON i.idCursoProgramado = cp.idCursoProgramado
        GROUP BY cp.ciclo
        ORDER BY cp.ciclo ASC
    """)
    List<ReporteInscritosPorCicloDTO> inscritosPorCiclo();

    // Reporte 4: top N cursos por promedio
    @Query("""
        SELECT new com.gestion_academica_db.gestion_academica_db.dto.ReporteTopCursoPromedioDTO(
            cc.nombre,
            AVG(i.notaFinal)
        )
        FROM Inscripcion i
        JOIN CursoProgramado cp ON i.idCursoProgramado = cp.idCursoProgramado
        JOIN CatalogoCurso cc ON cp.codigoCurso = cc.codigoCurso
        GROUP BY cc.nombre
        ORDER BY AVG(i.notaFinal) DESC
    """)
    List<ReporteTopCursoPromedioDTO> topCursosPorPromedio(Pageable pageable);
}
