package com.springboot.calderon.telefonica.modelo;

import jakarta.validation.constraints.NotNull;

public class PruebaEstudianteDTO {

	//@NotNull(message = "debe ingresar el eid del estudiante")
	private Integer eid;
	
	//@NotNull(message = "debe ingresar el nombre")
	private String nombre;
	
	//@NotNull(message = "debe ingresar la especialidad")
	private String especialidad;
	
	private String grado;
	
}
