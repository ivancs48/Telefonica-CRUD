package com.springboot.calderon.telefonica.modelo;

import com.springboot.calderon.telefonica.entities.PruebaEstudiante;

import jakarta.validation.constraints.NotNull;

public class PruebaEstudianteDTO {

	@NotNull(message = "debe ingresar el eid del estudiante")
	private Integer eid;
	
	@NotNull(message = "debe ingresar el nombre")
	private String nombre;
	
	@NotNull(message = "debe ingresar la especialidad")
	private String especialidad;
	
	private String grado;
	
	public PruebaEstudianteDTO() {
		
	}
	
	public PruebaEstudianteDTO(PruebaEstudiante pruebaEstudiante) {
		super();
		this.eid = pruebaEstudiante.getEid();
		this.nombre = pruebaEstudiante.getNombre();
		this.especialidad = pruebaEstudiante.getEspecialidad();
		this.grado = pruebaEstudiante.getGrado();
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

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}
	
	public static PruebaEstudiante PruebaEstudiante2PruebaEstudianteDTO(PruebaEstudianteDTO pruebaEstudianteDto) {
		PruebaEstudiante pruebaEstudiante = new PruebaEstudiante();
		pruebaEstudiante.setEid(pruebaEstudianteDto.getEid());
		pruebaEstudiante.setNombre(pruebaEstudianteDto.getNombre());
		pruebaEstudiante.setEspecialidad(pruebaEstudianteDto.getEspecialidad());
		pruebaEstudiante.setGrado(pruebaEstudianteDto.getGrado());
		
		return pruebaEstudiante;
	}
}
