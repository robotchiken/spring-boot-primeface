package com.takuba.comics.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

public class ComicRequest {
	@PositiveOrZero
	private int idComics; 
	@Positive(message="Se debe indicar la editorial")
	private int editorialId;
	@PositiveOrZero
	private int enpublicacion;
	@NotNull(message="La fecha no puede ser nula")
	private Date fecha;
	@Positive(message="El número debe de ser mayor a cero")
	private int numero;
	@PositiveOrZero(message="El número final solamente pude ser cero o mayor a cero")
	private int numerofinal;
	@Positive(message="Se debe de indicar la periodicidad")
	private int periodicidadId;
	@NotNull(message="El precio no puede ser nulo")
	private double precio;
	@Size(min = 5, max = 200, message = "El titulo debe de estar entre 10 y 200 caracteres")
	private String titulo;
	
	public ComicRequest() {
		
	}
	public ComicRequest(int editorialId, int enpublicacion, Date fecha, int numero, int numerofinal,
			int periodicidadId, double precio, String titulo) {
		super();
		this.editorialId = editorialId;
		this.enpublicacion = enpublicacion;
		this.fecha = fecha;
		this.numero = numero;
		this.numerofinal = numerofinal;
		this.periodicidadId = periodicidadId;
		this.precio = precio;
		this.titulo = titulo;
	}
	public int getEditorialId() {
		return editorialId;
	}
	public void setEditorialId(int editorialId) {
		this.editorialId = editorialId;
	}
	public int getEnpublicacion() {
		return enpublicacion;
	}
	public void setEnpublicacion(int enpublicacion) {
		this.enpublicacion = enpublicacion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getNumerofinal() {
		return numerofinal;
	}
	public void setNumerofinal(int numerofinal) {
		this.numerofinal = numerofinal;
	}
	public int getPeriodicidadId() {
		return periodicidadId;
	}
	public void setPeriodicidadId(int periodicidadId) {
		this.periodicidadId = periodicidadId;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getIdComics() {
		return idComics;
	}
	public void setIdComics(int idComics) {
		this.idComics = idComics;
	}
	
}
