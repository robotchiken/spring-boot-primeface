package org.acme.sample.web;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.acme.sample.bean.SortbyComicId;
import org.acme.sample.model.Calendario;
import org.acme.sample.model.Comic;
import org.acme.sample.repository.CalendarioRepository;
import org.acme.sample.repository.ComicRepository;
import org.acme.sample.repository.EditorialRepository;
import org.acme.sample.repository.PeriodicidadRepository;
import org.acme.sample.repository.TodoRepositoryImpl;
import org.acme.util.FechasUtil;
import org.primefaces.event.DragDropEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("formController")
@Scope("request")
public class FormController {
	
	Logger log = LoggerFactory.getLogger(FormController.class);
	
	@Autowired
	private FormBean formBean;
	
	@Autowired
	CalendarioRepository calendarioRepository;
	
	@Autowired
	ComicRepository comicRepository;
	
	@Autowired
	TodoRepositoryImpl todoRepository;
	
	@Autowired
	EditorialRepository editorialRepository;
	
	@Autowired
	PeriodicidadRepository perioRepository;
	
	private int userId;
	
	private List<String>listaMeses = Arrays.asList("Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre");
	
	public void submit() {
	    userId = Integer.parseInt(formBean.getField());
	    formBean.setUserId(userId);
	    llenarTablas();
	    Collections.sort(formBean.getComicsDisponibles(),new SortbyComicId());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Comics del usuario"));
		
	}
	
	public void reset() {
	    formBean.getSubmittedValues().clear();
	    formBean.setField(null);
	    formBean.setCalendario(null);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Form reset."));
	}

	public void onComicDrop(DragDropEvent ddEvent) {
        Comic comic= ((Comic) ddEvent.getData());
        org.acme.sample.bean.FormBean tmp  = new org.acme.sample.bean.FormBean();
        tmp.setIdComic(comic.getIdComic());
        tmp.setTitulo(comic.getTitulo());
        tmp.setFechaPublicacion(new Date());
        formBean.getSelectedComicsCalendar().add(tmp);
        formBean.getComicsDisponibles().remove(comic);
    }
	
	public void remove(org.acme.sample.bean.FormBean com){
		formBean.getSelectedComicsCalendar().remove(com);
		Comic comicTmp = comicRepository.findOne(com.getIdComic());
		formBean.getComicsDisponibles().add(comicTmp);
		Collections.sort(formBean.getComicsDisponibles(),new SortbyComicId());
	}
	public void buy(org.acme.sample.bean.FormBean com){
		if(com.getNumero() != null){
			formBean.getSelectedComicsCalendar().remove(com);
			com.setIdUsuario(formBean.getUserId());
			todoRepository.agregarComicCalendario(com);
			llenarTablas();
		}else{
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se debe de capturar el numero"));
		}
	}
	
	public List<String> getEditoriales(){
		return editorialRepository.getListadoEditoriales();
	}
	
	public List<String> getPeriodicidades(){
		return perioRepository.getListaPeriodicidad();
	}
	
	public boolean filterByPrice(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if(filterText == null||filterText.equals("")) {
            return true;
        }
         
        if(value == null) {
            return false;
        }
         
        return ((Comparable<BigDecimal>) value).compareTo(new BigDecimal(filterText)) == 0;
    }
	
	public BigDecimal getTotalCalendario(){
		BigDecimal total=new BigDecimal(0);
		if(formBean.getUserId() != null){
			total=calendarioRepository.calcularTotal(formBean.getUserId());
		}
		return total;
	}
	
	public void removeFromCalendar(Calendario cal){
		calendarioRepository.delete(cal.getId());
		llenarTablas();
	}
	
	public void buyFromCalendar(Calendario cal){
		Date fechaPublicar = FechasUtil.calcularMes(cal.getFechaPublicar(), cal.getComic().getPeriodicidad().getTiempo());
		cal.getComic().getPeriodicidad().getTiempo();
		todoRepository.actualizarCalendario(formBean.getUserId(),cal.getComic().getIdComic(),fechaPublicar);
		llenarTablas();
	}
	
	private void llenarTablas(){
		formBean.setComicsDisponibles(comicRepository.findComicsNotInCalendar(formBean.getUserId()));
		List<Calendario> calendario = calendarioRepository.buscarCalendario(formBean.getUserId());
	    formBean.setCalendario(calendario);
	}

	public List<String> getListaMeses() {
		return listaMeses;
	}

	public void setListaMeses(List<String> listaMeses) {
		this.listaMeses = listaMeses;
	}
	
	public boolean filterByFecha(Object value, Object filter, Locale locale){
		
		return true;
	}
}
