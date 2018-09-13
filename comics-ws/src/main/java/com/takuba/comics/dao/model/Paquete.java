package com.takuba.comics.dao.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the PAQUETE database table.
 * 
 */
@Entity
@Table(name="PAQUETE" ,schema="APP")
public class Paquete implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private int idsistema;

	private String observacionespaquete;

	private String paquete;

	private int tipopaquete;

	public Paquete() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getIdsistema() {
		return this.idsistema;
	}

	public void setIdsistema(int idsistema) {
		this.idsistema = idsistema;
	}

	public String getObservacionespaquete() {
		return this.observacionespaquete;
	}

	public void setObservacionespaquete(String observacionespaquete) {
		this.observacionespaquete = observacionespaquete;
	}

	public String getPaquete() {
		return this.paquete;
	}

	public void setPaquete(String paquete) {
		this.paquete = paquete;
	}

	public int getTipopaquete() {
		return this.tipopaquete;
	}

	public void setTipopaquete(int tipopaquete) {
		this.tipopaquete = tipopaquete;
	}

}