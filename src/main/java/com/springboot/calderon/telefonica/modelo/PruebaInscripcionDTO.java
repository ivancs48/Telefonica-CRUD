package com.springboot.calderon.telefonica.modelo;

import com.springboot.calderon.telefonica.entities.PruebaInscripcion;

import jakarta.validation.constraints.NotNull;

public class PruebaInscripcionDTO {

	private Integer eid;

	@NotNull(message = "dene ingresar el nombre de la clase")
	private String nombreClase;

	@NotNull(message = "debe ingresar la posicion")
	private Integer posicion;

	public PruebaInscripcionDTO() {

	}

	public PruebaInscripcionDTO(PruebaInscripcion pruebaInscripcion) {
		super();
		this.eid = pruebaInscripcion.getEid();
		this.nombreClase = pruebaInscripcion.getNombreClase();
		if (pruebaInscripcion.getPosicion() != null) {
			this.posicion = pruebaInscripcion.getPosicion();
		}
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getNombreClase() {
		return nombreClase;
	}

	public void setNombreClase(String nombreClase) {
		this.nombreClase = nombreClase;
	}

	public Integer getPosicion() {
		return posicion;
	}

	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
	}

	public static PruebaInscripcion PruebaInscripcion2PruebaInscripcionDTO(PruebaInscripcionDTO pruebaInscripcionDTO) {
		PruebaInscripcion pruebaInscripcion = new PruebaInscripcion();
		pruebaInscripcion.setEid(pruebaInscripcionDTO.getEid());
		pruebaInscripcion.setNombreClase(pruebaInscripcionDTO.getNombreClase());
		if (pruebaInscripcionDTO.getPosicion() != null) {
		    pruebaInscripcion.setPosicion(pruebaInscripcionDTO.getPosicion());
		}

		return pruebaInscripcion;
	}

}
