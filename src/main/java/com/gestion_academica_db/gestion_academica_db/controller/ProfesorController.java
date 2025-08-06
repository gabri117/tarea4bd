package com.gestion_academica_db.gestion_academica_db.controller;

import com.gestion_academica_db.gestion_academica_db.dto.ProfesorDTO;
import com.gestion_academica_db.gestion_academica_db.dto.ProfesorMapper;
import com.gestion_academica_db.gestion_academica_db.service.ProfesorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {
    private final ProfesorService service;

    public ProfesorController(ProfesorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProfesorDTO> crear(@RequestBody ProfesorDTO dto) {
        var profesor = ProfesorMapper.toEntity(dto);
        var guardado = service.crear(profesor);
        return ResponseEntity.ok(ProfesorMapper.toDTO(guardado));
    }

    @GetMapping
    public List<ProfesorDTO> obtenerTodos() {
        return service.obtenerTodos().stream()
                .map(ProfesorMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfesorDTO> obtenerPorId(@PathVariable String id) {
        return service.obtenerPorId(id)
                .map(ProfesorMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfesorDTO> actualizar(@PathVariable String id, @RequestBody ProfesorDTO dto) {
        var actualizado = service.actualizar(id, ProfesorMapper.toEntity(dto));
        return ResponseEntity.ok(ProfesorMapper.toDTO(actualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}