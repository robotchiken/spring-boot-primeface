package org.acme.sample.bean;

import java.util.Date;

public class FormBean {
	private Integer idUsuario;
	private String fecha;
	private Integer idComic;
	private Date fechaPublicacion;
	public FormBean(Integer idUsuario, Integer idComic, Integer numero, String titulo) {
		super();
		this.idUsuario = idUsuario;
		this.idComic = idComic;
		this.numero = numero;
		this.titulo = titulo;
		this.setFechaPublicacion(new Date());
	}

	private Integer numero;
	private String titulo;
	public FormBean(){
		
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getIdComic() {
		return idComic;
	}

	public void setIdComic(Integer idComic) {
		this.idComic = idComic;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
}
