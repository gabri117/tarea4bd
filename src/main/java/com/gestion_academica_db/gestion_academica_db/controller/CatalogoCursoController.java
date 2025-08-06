package com.gestion_academica_db.gestion_academica_db.controller;

import com.gestion_academica_db.gestion_academica_db.dto.CatalogoCursoDTO;
import com.gestion_academica_db.gestion_academica_db.dto.CatalogoCursoMapper;
import com.gestion_academica_db.gestion_academica_db.entity.CatalogoCurso;
import com.gestion_academica_db.gestion_academica_db.service.CatalogoCursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cursos")
public class CatalogoCursoController {
    private final CatalogoCursoService service;

    public CatalogoCursoController(CatalogoCursoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CatalogoCursoDTO> crear(@RequestBody CatalogoCursoDTO dto) {
        CatalogoCurso prerrequisito = null;
        if (dto.getCodigoPrerrequisito() != null) {
            prerrequisito = service.obtenerPorId(dto.getCodigoPrerrequisito()).orElse(null);
        }
        var curso = CatalogoCursoMapper.toEntity(dto, prerrequisito);
        var guardado = service.crear(curso);
        return ResponseEntity.ok(CatalogoCursoMapper.toDTO(guardado));
    }

    @GetMapping
    public List<CatalogoCursoDTO> obtenerTodos() {
        return service.obtenerTodos().stream()
                .map(CatalogoCursoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CatalogoCursoDTO> obtenerPorId(@PathVariable String id) {
        return service.obtenerPorId(id)
                .map(CatalogoCursoMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CatalogoCursoDTO> actualizar(@PathVariable String id, @RequestBody CatalogoCursoDTO dto) {
        CatalogoCurso prerrequisito = null;
        if (dto.getCodigoPrerrequisito() != null) {
            prerrequisito = service.obtenerPorId(dto.getCodigoPrerrequisito()).orElse(null);
        }
        var actualizado = service.actualizar(id, CatalogoCursoMapper.toEntity(dto, prerrequisito));
        return ResponseEntity.ok(CatalogoCursoMapper.toDTO(actualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}