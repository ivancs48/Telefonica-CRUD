package com.springboot.calderon.telefonica.modelo;

import jakarta.validation.constraints.NotNull;

public class PruebaInscripcionDTO {

	private Integer eid;

	//@NotNull(message = "dene ingresar el nombre de la clase")
	private String nombreClase;

	//@NotNull(message = "debe ingresar la posicion")
	private Integer posicion;
}
