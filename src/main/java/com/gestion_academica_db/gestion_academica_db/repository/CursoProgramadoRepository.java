package com.gestion_academica_db.gestion_academica_db.repository;

import com.gestion_academica_db.gestion_academica_db.dto.ReporteCursosPorProfesorDTO;
import com.gestion_academica_db.gestion_academica_db.entity.CursoProgramado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CursoProgramadoRepository extends JpaRepository<CursoProgramado, Integer> {

    @Query("""
        SELECT new com.gestion_academica_db.gestion_academica_db.dto.ReporteCursosPorProfesorDTO(
            p.nombreCompleto,
            COUNT(cp)
        )
        FROM CursoProgramado cp
        JOIN Profesor p ON cp.codigoProfesor = p.codigoProfesor
        GROUP BY p.nombreCompleto
        ORDER BY COUNT(cp) DESC
    """)
    List<ReporteCursosPorProfesorDTO> contarCursosPorProfesor();
}
