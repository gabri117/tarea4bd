package com.gestion_academica_db.gestion_academica_db.controller;

import com.gestion_academica_db.gestion_academica_db.entity.CatalogoCurso;
import com.gestion_academica_db.gestion_academica_db.service.CatalogoCursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CatalogoCursoController {
    private final CatalogoCursoService service;

    public CatalogoCursoController(CatalogoCursoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CatalogoCurso> crear(@RequestBody CatalogoCurso c) {
        return ResponseEntity.ok(service.crear(c));
    }

    @GetMapping
    public List<CatalogoCurso> obtenerTodos() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CatalogoCurso> obtenerPorId(@PathVariable String id) {
        return service.obtenerPorId(id).map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CatalogoCurso> actualizar(@PathVariable String id, @RequestBody CatalogoCurso c) {
        return ResponseEntity.ok(service.actualizar(id, c));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}