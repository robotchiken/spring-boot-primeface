package com.takuba.comics.dao.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the COMICS database table.
 * 
 */
@Entity
@Table(name="COMICS",schema="APP")
@NamedQueries({
	@NamedQuery(name="Comic.findComics",query="SELECT c,p,e FROM Comic c, Editoriale e, Peridiocidad p WHERE c.editorialId = e.idEditorial AND p.idPeriodicidad = c.periodicidadId"),
	@NamedQuery(name="Comic.buscarComic",query="SELECT c,p,e FROM Comic c, Editoriale e, Peridiocidad p WHERE c.editorialId = e.idEditorial AND p.idPeriodicidad = c.periodicidadId AND c.titulo =?1")
})

public class Comic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_COMICS")
	private int idComics;

	@Column(name="EDITORIAL_ID")
	private int editorialId;

	private int enpublicacion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private int numero;

	private int numerofinal;

	@Column(name="PERIODICIDAD_ID")
	private int periodicidadId;

	private double precio;

	private String titulo;

	public Comic() {
	}

	public int getIdComics() {
		return this.idComics;
	}

	public void setIdComics(int idComics) {
		this.idComics = idComics;
	}

	public int getEditorialId() {
		return this.editorialId;
	}

	public void setEditorialId(int editorialId) {
		this.editorialId = editorialId;
	}

	public int getEnpublicacion() {
		return this.enpublicacion;
	}

	public void setEnpublicacion(int enpublicacion) {
		this.enpublicacion = enpublicacion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getNumerofinal() {
		return this.numerofinal;
	}

	public void setNumerofinal(int numerofinal) {
		this.numerofinal = numerofinal;
	}

	public int getPeriodicidadId() {
		return this.periodicidadId;
	}

	public void setPeriodicidadId(int periodicidadId) {
		this.periodicidadId = periodicidadId;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}