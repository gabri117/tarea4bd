package com.gestion_academica_db.gestion_academica_db.service;

import com.gestion_academica_db.gestion_academica_db.dto.*;
import com.gestion_academica_db.gestion_academica_db.repository.CursoProgramadoRepository;
import com.gestion_academica_db.gestion_academica_db.repository.InscripcionRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReporteService {

    private final CursoProgramadoRepository cursoProgramadoRepository;
    private final InscripcionRepository inscripcionRepository;

    public ReporteService(CursoProgramadoRepository cursoProgramadoRepository, InscripcionRepository inscripcionRepository) {
        this.cursoProgramadoRepository = cursoProgramadoRepository;
        this.inscripcionRepository = inscripcionRepository;
    }

    public List<ReporteCursosPorProfesorDTO> cursosPorProfesor() {
        return cursoProgramadoRepository.contarCursosPorProfesor();
    }

    public List<ReportePromedioPorCursoDTO> promedioPorCurso() {
        return inscripcionRepository.promedioPorCurso();
    }

    public List<ReporteInscritosPorCicloDTO> inscritosPorCiclo() {
        return inscripcionRepository.inscritosPorCiclo();
    }

    public List<ReporteTopCursoPromedioDTO> topCursosPorPromedio(int limit) {
        return inscripcionRepository.topCursosPorPromedio(PageRequest.of(0, limit));
    }
}
