package com.takuba.comics.dao.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the EDITORIALES database table.
 * 
 */
@Entity
@Table(name="EDITORIALES",schema="APP")
@NamedQuery(name="Editoriale.findId", query="SELECT e FROM Editoriale e WHERE e.idEditorial = ?1")
public class Editoriale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_EDITORIAL")
	private int idEditorial;

	private String nombre;

	public Editoriale() {
	}

	public int getIdEditorial() {
		return this.idEditorial;
	}

	public void setIdEditorial(int idEditorial) {
		this.idEditorial = idEditorial;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}