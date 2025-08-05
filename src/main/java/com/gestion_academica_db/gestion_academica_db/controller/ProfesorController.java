package com.gestion_academica_db.gestion_academica_db.controller;

import com.gestion_academica_db.gestion_academica_db.entity.Profesor;
import com.gestion_academica_db.gestion_academica_db.service.ProfesorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {
    private final ProfesorService service;

    public ProfesorController(ProfesorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Profesor> crear(@RequestBody Profesor p) {
        return ResponseEntity.ok(service.crear(p));
    }

    @GetMapping
    public List<Profesor> obtenerTodos() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profesor> obtenerPorId(@PathVariable String id) {
        return service.obtenerPorId(id).map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profesor> actualizar(@PathVariable String id, @RequestBody Profesor p) {
        return ResponseEntity.ok(service.actualizar(id, p));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}