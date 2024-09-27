package com.springboot.calderon.telefonica.modelo;

import com.springboot.calderon.telefonica.entities.PruebaClase;

//import jakarta.validation.constraints.NotNull;

public class PruebaClaseDTO {

	private Integer eid;
	// @NotNull(message = "Debe ingresar el nombre")
	private String nombre;

	// @NotNull(message = "Debe ingresar el aula")
	private String aula;

	// @NotNull(message = "debe ingresar el horario")
	private String horario;

	public PruebaClaseDTO() {

	}

	public PruebaClaseDTO(PruebaClase pruebaClase) {
		super();
		this.eid = pruebaClase.getEid();
		this.nombre = pruebaClase.getNombre();
		this.aula = pruebaClase.getAula();
		this.horario = pruebaClase.getHorario();
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public static PruebaClase pruebaClase2PruebaClaseDTO(PruebaClaseDTO pruebaClaseDTO) {
		PruebaClase pruebaClase = new PruebaClase();
		pruebaClase.setEid(pruebaClaseDTO.getEid());
		pruebaClase.setNombre(pruebaClaseDTO.getNombre());
		pruebaClase.setAula(pruebaClaseDTO.getAula());
		pruebaClase.setHorario(pruebaClaseDTO.getHorario());
		return pruebaClase;
	}

}
