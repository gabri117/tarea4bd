package com.gestion_academica_db.gestion_academica_db.controller;

import com.gestion_academica_db.gestion_academica_db.dto.EstudianteDTO;
import com.gestion_academica_db.gestion_academica_db.dto.EstudianteMapper;
import com.gestion_academica_db.gestion_academica_db.service.EstudianteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
    private final EstudianteService service;

    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EstudianteDTO> crear(@RequestBody EstudianteDTO dto) {
        var estudiante = EstudianteMapper.toEntity(dto);
        var guardado = service.crear(estudiante);
        return ResponseEntity.ok(EstudianteMapper.toDTO(guardado));
    }

    @GetMapping
    public List<EstudianteDTO> obtenerTodos() {
        return service.obtenerTodos().stream()
                .map(EstudianteMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDTO> obtenerPorId(@PathVariable String id) {
        return service.obtenerPorId(id)
                .map(EstudianteMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstudianteDTO> actualizar(@PathVariable String id, @RequestBody EstudianteDTO dto) {
        var actualizado = service.actualizar(id, EstudianteMapper.toEntity(dto));
        return ResponseEntity.ok(EstudianteMapper.toDTO(actualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}