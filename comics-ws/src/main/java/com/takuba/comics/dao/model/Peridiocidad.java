package com.takuba.comics.dao.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PERIDIOCIDAD database table.
 * 
 */
@Entity
@Table(name="peridiocidad",schema="APP")
@NamedQuery(name="Peridiocidad.findId",query="SELECT p FROM Peridiocidad p WHERE p.idPeriodicidad =?1")
public class Peridiocidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PERIODICIDAD")
	private int idPeriodicidad;

	private String descripcion;

	private int diasmeses;

	private int tiempo;

	public Peridiocidad() {
	}

	public int getIdPeriodicidad() {
		return this.idPeriodicidad;
	}

	public void setIdPeriodicidad(int idPeriodicidad) {
		this.idPeriodicidad = idPeriodicidad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getDiasmeses() {
		return this.diasmeses;
	}

	public void setDiasmeses(int diasmeses) {
		this.diasmeses = diasmeses;
	}

	public int getTiempo() {
		return this.tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

}