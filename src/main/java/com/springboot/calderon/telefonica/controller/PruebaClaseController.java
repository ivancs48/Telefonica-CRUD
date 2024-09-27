package com.springboot.calderon.telefonica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.calderon.telefonica.entities.PruebaClase;
import com.springboot.calderon.telefonica.modelo.PruebaClaseDTO;
import com.springboot.calderon.telefonica.services.PruebaClaseService;

@RestController
@RequestMapping("/api/pruebaclases")
public class PruebaClaseController {

	@Autowired
	private PruebaClaseService service;

	@Transactional(readOnly = true)
	@GetMapping
	public ResponseEntity<List<PruebaClaseDTO>> getAll() {
		List<PruebaClaseDTO> listado = service.findAll();
		return new ResponseEntity<>(listado, HttpStatus.OK);
	}

	@Transactional(readOnly = true)
	@GetMapping(value = "/{eid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PruebaClaseDTO> getById(@PathVariable int eid) {
		PruebaClaseDTO pruebaClaseDto = service.findById(eid);
		return new ResponseEntity<>(pruebaClaseDto, HttpStatus.OK);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PruebaClaseDTO> create(@RequestBody PruebaClaseDTO pruebaClaseDto) {
		pruebaClaseDto = service.save(pruebaClaseDto);
		return new ResponseEntity<>(pruebaClaseDto, HttpStatus.OK);
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PruebaClaseDTO> actualizar(@RequestBody PruebaClaseDTO pruebaClaseDto) {
		PruebaClaseDTO modificado = service.actualiza(pruebaClaseDto);
		return new ResponseEntity<>(modificado, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{eid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteById(@PathVariable int eid) {
		service.deleteById(eid);
		return new ResponseEntity<>("Estudiante borrado", HttpStatus.OK);
	}
}
