package com.gestion_academica_db.gestion_academica_db.controller;

import com.gestion_academica_db.gestion_academica_db.entity.Estudiante;
import com.gestion_academica_db.gestion_academica_db.service.EstudianteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
    private final EstudianteService service;

    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Estudiante> crear(@RequestBody Estudiante e) {
        return ResponseEntity.ok(service.crear(e));
    }

    @GetMapping
    public List<Estudiante> obtenerTodos() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerPorId(@PathVariable String id) {
        return service.obtenerPorId(id).map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizar(@PathVariable String id, @RequestBody Estudiante e) {
        return ResponseEntity.ok(service.actualizar(id, e));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}