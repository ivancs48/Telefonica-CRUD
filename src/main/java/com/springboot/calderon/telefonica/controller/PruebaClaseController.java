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

import com.springboot.calderon.telefonica.entities.PruebaClase;
import com.springboot.calderon.telefonica.services.PruebaClaseService;

@RestController
@RequestMapping("/api/pruebaclases")
public class PruebaClaseController {

    @Autowired
    private PruebaClaseService service;

    @GetMapping
    public List<PruebaClase> getAll() {
        return service.findAll();
    }

    @GetMapping("/{eid}")
    public ResponseEntity<PruebaClase> getById(@PathVariable int eid) {
        return service.findById(eid)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PruebaClase create(@RequestBody PruebaClase clase) {
        return service.save(clase);
    }

    @DeleteMapping("/{eid}")
    public ResponseEntity<Void> deleteById(@PathVariable int eid) {
        service.deleteById(eid);
        return ResponseEntity.noContent().build();
    }
}
