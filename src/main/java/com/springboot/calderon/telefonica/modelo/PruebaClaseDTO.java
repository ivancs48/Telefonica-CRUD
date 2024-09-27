package com.springboot.calderon.telefonica.modelo;

import jakarta.validation.constraints.NotNull;

public class PruebaClaseDTO {

	private Integer eid;
	@NotNull(message = "Debe ingresar el nombre")
    private String nombre;
	
	//@NotNull(message = "Debe ingresar el aula")
    private String aula;
	
	//@NotNull(message = "debe ingresar el horario")
    private String horario;
}
