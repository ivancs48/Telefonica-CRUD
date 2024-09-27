package com.springboot.calderon.telefonica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.calderon.telefonica.entities.PruebaInscripcion;
import com.springboot.calderon.telefonica.services.PruebaInscripcionService;

@RestController
@RequestMapping("/api/pruebainscripciones")
public class PruebaInscripcionController {

    @Autowired
    private PruebaInscripcionService service;

    @GetMapping
    public List<PruebaInscripcion> getAll() {
        return service.findAll();
    }

    @GetMapping("/{eid}")
    public ResponseEntity<PruebaInscripcion> getById(@PathVariable int eid) {
        return service.findById(eid)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PruebaInscripcion create(@RequestBody PruebaInscripcion inscripcion) {
        return service.save(inscripcion);
    }

    @DeleteMapping("/{eid}")
    public ResponseEntity<Void> deleteById(@PathVariable int eid) {
        service.deleteById(eid);
        return ResponseEntity.noContent().build();
    }
}
