package com.gestion_academica_db.gestion_academica_db.controller;

import com.gestion_academica_db.gestion_academica_db.dto.*;
import com.gestion_academica_db.gestion_academica_db.service.ReporteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    private final ReporteService reporteService;

    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    @GetMapping("/cursos-por-profesor")
    public ResponseEntity<List<ReporteCursosPorProfesorDTO>> cursosPorProfesor() {
        return ResponseEntity.ok(reporteService.cursosPorProfesor());
    }

    @GetMapping("/promedio-por-curso")
    public ResponseEntity<List<ReportePromedioPorCursoDTO>> promedioPorCurso() {
        return ResponseEntity.ok(reporteService.promedioPorCurso());
    }

    @GetMapping("/inscritos-por-ciclo")
    public ResponseEntity<List<ReporteInscritosPorCicloDTO>> inscritosPorCiclo() {
        return ResponseEntity.ok(reporteService.inscritosPorCiclo());
    }

    @GetMapping("/top-cursos-por-promedio")
    public ResponseEntity<List<ReporteTopCursoPromedioDTO>> topCursosPorPromedio(
            @RequestParam(defaultValue = "3") int limit) {
        return ResponseEntity.ok(reporteService.topCursosPorPromedio(limit));
    }
}

