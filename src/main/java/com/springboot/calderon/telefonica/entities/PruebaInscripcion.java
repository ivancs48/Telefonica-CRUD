package com.springboot.calderon.telefonica.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pruebainscripcion")
public class PruebaInscripcion {

	@Id
	@Column(name = "eid", nullable = false)
	private Integer eid;

	@Column(name = "nombre_clase", nullable = false)
	private String nombreClase;

	@Column(name = "posicion", nullable = false)
	private Integer posicion;

	@ManyToOne
	@JoinColumn(name = "eid", referencedColumnName = "eid", insertable = false, updatable = false)
	private PruebaEstudiante pruebaEstudiante;

	// Getters y setters

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

	public PruebaEstudiante getPruebaEstudiante() {
		return pruebaEstudiante;
	}

	public void setPruebaEstudiante(PruebaEstudiante pruebaEstudiante) {
		this.pruebaEstudiante = pruebaEstudiante;
	}
}
