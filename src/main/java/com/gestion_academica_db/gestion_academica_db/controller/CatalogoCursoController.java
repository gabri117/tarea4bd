package com.gestion_academica_db.gestion_academica_db.controller;

import com.gestion_academica_db.gestion_academica_db.dto.CatalogoCursoDTO;
//import com.gestion_academica_db.gestion_academica_db.dto.CatalogoCursoMapper;
//import com.gestion_academica_db.gestion_academica_db.entity.CatalogoCurso;
import com.gestion_academica_db.gestion_academica_db.service.CatalogoCursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
//import java.util.stream.Collectors;

@RestController
@RequestMapping("/cursos")
public class CatalogoCursoController {
    private final CatalogoCursoService service;
    public CatalogoCursoController(CatalogoCursoService service) { this.service = service; }

    @GetMapping
    public List<CatalogoCursoDTO> listar(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) Integer creditosMin) {
        return service.listar(nombre, creditosMin);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<CatalogoCursoDTO> porId(@PathVariable String codigo) {
        return ResponseEntity.ok(service.porId(codigo));
    }
}