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

import com.springboot.calderon.telefonica.entities.PruebaEstudiante;
import com.springboot.calderon.telefonica.services.PruebaEstudianteService;

@RestController
@RequestMapping("/api/pruebaestudiantes")
public class PruebaEstudianteController {

	@Autowired
	private PruebaEstudianteService service;

	@GetMapping
	public List<PruebaEstudiante> getAll() {
		return service.findAll();
	}

	@GetMapping("/{eid}")
	public ResponseEntity<PruebaEstudiante> getById(@PathVariable int eid) {
		return service.findById(eid).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public PruebaEstudiante create(@RequestBody PruebaEstudiante estudiante) {
		return service.save(estudiante);
	}

	@DeleteMapping("/{eid}")
	public ResponseEntity<Void> deleteById(@PathVariable int eid) {
		service.deleteById(eid);
		return ResponseEntity.noContent().build();
	}
}
