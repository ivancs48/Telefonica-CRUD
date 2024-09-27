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

import com.springboot.calderon.telefonica.modelo.PruebaInscripcionDTO;
import com.springboot.calderon.telefonica.services.PruebaInscripcionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pruebainscripciones")
public class PruebaInscripcionController {

    @Autowired
    private PruebaInscripcionService service;

    @Tag(name = "Prueba Inscripcion")
	@Operation(summary = "Listar Inscripcion", operationId = "getAll", description = "Obtiene la lista completa de los registros de Inscripcion", method = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "202", description = "La consulta es realizada correctamente") })
	@Transactional(readOnly = true)
    @GetMapping
    public ResponseEntity<List<PruebaInscripcionDTO>> getAll() {
    	List<PruebaInscripcionDTO> listado = service.findAll();
		return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    @Tag(name = "Prueba Inscripcion")
	@Operation(summary = "Consultar Inscripcion por ID", operationId = "getById", description = "Consulta por id la Inscripcion", method = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "202", description = "La consulta es realizada correctamente") })
	@Transactional(readOnly = true)
	@GetMapping(value = "/{eid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PruebaInscripcionDTO> getById(@PathVariable int eid) {
    	PruebaInscripcionDTO pruebaClaseDto = service.findById(eid);
		return new ResponseEntity<>(pruebaClaseDto, HttpStatus.OK);
	}

    @Tag(name = "Prueba Inscripcion")
	@Operation(summary = "Registrar Inscripcion", operationId = "create", description = "Registra un Inscripcion", method = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "202", description = "La consulta es realizada correctamente") })
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@Valid @RequestBody PruebaInscripcionDTO pruebaInscripcionDTO, BindingResult result) {
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		}

		pruebaInscripcionDTO = service.save(pruebaInscripcionDTO);
		return new ResponseEntity<>(pruebaInscripcionDTO, HttpStatus.OK);
	}

	@Tag(name = "Prueba Inscripcion")
	@Operation(summary = "Actualiza un Inscripcion", operationId = "actualizar", description = "Actualiza un Inscripcion", method = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "202", description = "La consulta es realizada correctamente") })
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> actualizar(@Valid @RequestBody PruebaInscripcionDTO pruebaInscripcionDTO, BindingResult result) {
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		}
		PruebaInscripcionDTO modificado = service.actualiza(pruebaInscripcionDTO);
		return new ResponseEntity<>(modificado, HttpStatus.OK);
	}

	@Tag(name = "Prueba Inscripcion")
	@Operation(summary = "Elimina el Inscripcion por id", operationId = "deleteById", description = "Elimina la Inscripcion por id", method = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "202", description = "La consulta es realizada correctamente") })
	@DeleteMapping(value = "/{eid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteById(@PathVariable int eid) {
		service.deleteById(eid);
		return new ResponseEntity<>("Estudiante borrado", HttpStatus.OK);
	}
}
