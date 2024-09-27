package com.springboot.calderon.telefonica.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.calderon.telefonica.modelo.PruebaEstudianteDTO;
import com.springboot.calderon.telefonica.services.PruebaEstudianteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pruebaestudiantes")
public class PruebaEstudianteController {

	@Autowired
	private PruebaEstudianteService service;

	@Tag(name = "Prueba Estudiante")
	@Operation(summary = "Listar Estudiante", operationId = "getAll", description = "Obtiene la lista completa de los registros de Estudiante", method = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "202", description = "La consulta es realizada correctamente") })
	@Transactional(readOnly = true)
	@GetMapping
	public ResponseEntity<List<PruebaEstudianteDTO>> getAll() {
		 List<PruebaEstudianteDTO> listado = service.findAll();
		return new ResponseEntity<>(listado, HttpStatus.OK);
	}

	@Tag(name = "Prueba Estudiante")
	@Operation(summary = "Consultar Estudiante por ID", operationId = "getById", description = "Consulta por id la Estudiante", method = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "202", description = "La consulta es realizada correctamente") })
	@Transactional(readOnly = true)
	@GetMapping(value = "/{eid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PruebaEstudianteDTO> getById(@PathVariable int eid) {
		PruebaEstudianteDTO pruebaClaseDto = service.findById(eid);
		return new ResponseEntity<>(pruebaClaseDto, HttpStatus.OK);
	}

	@Tag(name = "Prueba Estudiante")
	@Operation(summary = "Registrar Estudiante", operationId = "create", description = "Registra un Estudiante", method = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "202", description = "La consulta es realizada correctamente") })
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@Valid @RequestBody PruebaEstudianteDTO pruebaEstudianteDTO, BindingResult result) {
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		}

		pruebaEstudianteDTO = service.save(pruebaEstudianteDTO);
		return new ResponseEntity<>(pruebaEstudianteDTO, HttpStatus.OK);
	}

	@Tag(name = "Prueba Estudiante")
	@Operation(summary = "Actualiza un Estudiante", operationId = "actualizar", description = "Actualiza un Estudiante", method = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "202", description = "La consulta es realizada correctamente") })
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> actualizar(@Valid @RequestBody PruebaEstudianteDTO pruebaEstudianteDTO, BindingResult result) {
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		}
		PruebaEstudianteDTO modificado = service.actualiza(pruebaEstudianteDTO);
		return new ResponseEntity<>(modificado, HttpStatus.OK);
	}

	@Tag(name = "Prueba Estudiante")
	@Operation(summary = "Elimina el Estudiante por id", operationId = "deleteById", description = "Elimina la Prueba clase por id", method = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "202", description = "La consulta es realizada correctamente") })
	@DeleteMapping(value = "/{eid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteById(@PathVariable int eid) {
		service.deleteById(eid);
		return new ResponseEntity<>("Estudiante borrado", HttpStatus.OK);
	}
}
