package com.gestion_academica_db.gestion_academica_db.controller;

import com.gestion_academica_db.gestion_academica_db.dto.EstudianteDTO;
//import com.gestion_academica_db.gestion_academica_db.dto.EstudianteMapper;
import com.gestion_academica_db.gestion_academica_db.service.EstudianteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
//import java.util.stream.Collectors;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
    private final EstudianteService service;
    public EstudianteController(EstudianteService service) { this.service = service; }

    @GetMapping
    public List<EstudianteDTO> listar(
            @RequestParam(required = false) String apellido,
            @RequestParam(required = false) String nombre) {
        return service.listar(apellido, nombre);
    }

    @GetMapping("/{carnet}")
    public ResponseEntity<EstudianteDTO> porId(@PathVariable String carnet) {
        return ResponseEntity.ok(service.porId(carnet));
    }
}