package com.takuba.comics.dto;

import com.takuba.comics.dao.model.Comic;
import com.takuba.comics.dao.model.Editoriale;
import com.takuba.comics.dao.model.Peridiocidad;

public class ComicReponse {
	private Comic comic;
	private Editoriale editorial;
	private Peridiocidad peridiocidad;
	public ComicReponse(){
		
	}
	public ComicReponse(Comic comic, Editoriale editorial, Peridiocidad peridiocidad) {
		super();
		this.comic = comic;
		this.editorial = editorial;
		this.peridiocidad = peridiocidad;
	}
	public Comic getComic() {
		return comic;
	}
	public void setComic(Comic comic) {
		this.comic = comic;
	}
	public Editoriale getEditorial() {
		return editorial;
	}
	public void setEditorial(Editoriale editorial) {
		this.editorial = editorial;
	}
	public Peridiocidad getPeridiocidad() {
		return peridiocidad;
	}
	public void setPeridiocidad(Peridiocidad peridiocidad) {
		this.peridiocidad = peridiocidad;
	}
	
}
