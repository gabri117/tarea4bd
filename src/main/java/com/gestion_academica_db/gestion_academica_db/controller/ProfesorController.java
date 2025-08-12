package com.gestion_academica_db.gestion_academica_db.controller;

import com.gestion_academica_db.gestion_academica_db.dto.ProfesorDTO;
//import com.gestion_academica_db.gestion_academica_db.dto.ProfesorMapper;
import com.gestion_academica_db.gestion_academica_db.service.ProfesorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
//import java.util.stream.Collectors;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {
    private final ProfesorService service;
    public ProfesorController(ProfesorService service) { this.service = service; }

    @GetMapping
    public List<ProfesorDTO> listar(@RequestParam(required = false) String nombre) {
        return service.listar(nombre);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfesorDTO> porId(@PathVariable String id) {
        return ResponseEntity.ok(service.porId(id));
    }
}