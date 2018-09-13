package org.acme.sample.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.acme.sample.jsf.FacesViewScope;
import org.acme.sample.model.Calendario;
import org.acme.sample.model.Comic;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("formBean")
@Scope(FacesViewScope.NAME)
public class FormBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
    private List<String> submittedValues = new ArrayList<>();
    
	private String field;

	private List<Calendario> calendario;
	
	private List<Comic> comicsDisponibles;
	
	private List<org.acme.sample.bean.FormBean> selectedComicsCalendar;
	
	private List<org.acme.sample.bean.FormBean> listBuyComics;
	
	private Integer userId;
	
	private List<Calendario> filteredCalendario;
	
	private List<org.acme.sample.bean.FormBean>filteredSelectedComicsCalendar;
	
	private List<Comic>filteredComic;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

    public List<String> getSubmittedValues() {
        return submittedValues;
    }

    public void setSubmittedValues(List<String> submittedValues) {
        this.submittedValues = submittedValues;
    }

	public void setCalendario(List<Calendario> calendario) {
		this.calendario = calendario;
		
	}

	public List<Calendario> getCalendario() {
		return calendario;
	}

	public List<Comic> getComicsDisponibles() {
		return comicsDisponibles;
	}

	public void setComicsDisponibles(List<Comic> comicsDisponibles) {
		this.comicsDisponibles = comicsDisponibles;
	}

	public List<org.acme.sample.bean.FormBean> getSelectedComicsCalendar() {
		if(this.selectedComicsCalendar == null){
			this.selectedComicsCalendar = new ArrayList<>();
		}
		return selectedComicsCalendar;
	}

	public void setSelectedComicsCalendar(List<org.acme.sample.bean.FormBean> selectedComicsCalendar) {
		this.selectedComicsCalendar = selectedComicsCalendar;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<org.acme.sample.bean.FormBean> getListBuyComics() {
		return listBuyComics;
	}

	public void setListBuyComics(List<org.acme.sample.bean.FormBean> listBuyComics) {
		this.listBuyComics = listBuyComics;
	}

	public List<Calendario> getFilteredCalendario() {
		return filteredCalendario;
	}

	public void setFilteredCalendario(List<Calendario> filteredCalendario) {
		this.filteredCalendario = filteredCalendario;
	}

	public List<org.acme.sample.bean.FormBean> getFilteredSelectedComicsCalendar() {
		return filteredSelectedComicsCalendar;
	}

	public void setFilteredSelectedComicsCalendar(List<org.acme.sample.bean.FormBean> filteredSelectedComicsCalendar) {
		this.filteredSelectedComicsCalendar = filteredSelectedComicsCalendar;
	}

	public List<Comic> getFilteredComic() {
		return filteredComic;
	}

	public void setFilteredComic(List<Comic> filteredComic) {
		this.filteredComic = filteredComic;
	}
	
}
