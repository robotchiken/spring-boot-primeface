package com.takuba.comics.service;

import java.util.List;

import javax.validation.Valid;
import javax.xml.ws.RequestWrapper;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.takuba.comics.dao.model.Comic;
import com.takuba.comics.dao.model.Editoriale;
import com.takuba.comics.dao.model.Peridiocidad;
import com.takuba.comics.dao.repository.ComicRepository;
import com.takuba.comics.dao.repository.EditorialRepository;
import com.takuba.comics.dao.repository.PeriodicidadRepository;
import com.takuba.comics.dto.ComicReponse;
import com.takuba.comics.dto.ComicRequest;
import com.takuba.comics.exception.ComicsException;

@RestController
public class ComicService {
	
	@Autowired
	private ComicRepository repository;
	@Autowired
	private EditorialRepository editorialRepository;
	@Autowired
	private PeriodicidadRepository pRepository;
	@Autowired
	private Mapper mapper;
	
	@RequestMapping(value="/listarComics", method=RequestMethod.GET)
	List<Comic>listarComics(){
		return repository.findComics();
	}
	
	@RequestMapping(value="/buscarComic",method=RequestMethod.GET)
	ComicReponse buscarComic(@Param(value="titulo") String titulo){
		Comic comic = repository.buscarComic(titulo);
		Editoriale editorial=editorialRepository.findId(comic.getEditorialId());
		Peridiocidad perio = pRepository.findId(comic.getPeriodicidadId());
		return new ComicReponse(comic,editorial, perio);
	}
	
	@RequestMapping(value="/numeroFinal", method=RequestMethod.GET)
	List<Comic>buscarNumeroFinal(@Param(value="numerofinal") Integer numerofinal){
		return repository.findByNumerofinalGreaterThan(numerofinal);
	}
	
	@RequestMapping(value="/insertarComic",method=RequestMethod.POST)
	public ComicReponse insertarComic(@RequestBody @Valid ComicRequest comicRequest){
		
		if(repository.findByTitulo(comicRequest.getTitulo()) != null){
			throw new ComicsException("Ya existe ese titulo");
		}
		Comic comic = mapper.map(comicRequest, Comic.class);
		Comic nuevo=repository.save(comic);
		Editoriale editorial=editorialRepository.findId(nuevo.getEditorialId());
		Peridiocidad peridiocidad = pRepository.findId(nuevo.getPeriodicidadId());
		return new ComicReponse(nuevo, editorial, peridiocidad);
	}
	@RequestMapping(value="/listarEditoriales",method=RequestMethod.GET)
	public List<Editoriale>listaEditoriales(){
		return editorialRepository.findAll();
	}
	@RequestMapping(value="/listarPeriodicidad",method=RequestMethod.GET)
	public List<Peridiocidad> listaPeriodicidad(){
		return pRepository.findAll();
	}
	
	public ComicRepository getRepository() {
		return repository;
	}

	public void setRepository(ComicRepository repository) {
		this.repository = repository;
	}

	public EditorialRepository getEditorialRepository() {
		return editorialRepository;
	}

	public void setEditorialRepository(EditorialRepository editorialRepository) {
		this.editorialRepository = editorialRepository;
	}

	public PeriodicidadRepository getpRepository() {
		return pRepository;
	}

	public void setpRepository(PeriodicidadRepository pRepository) {
		this.pRepository = pRepository;
	}

	public Mapper getMapper() {
		return mapper;
	}

	public void setMapper(Mapper mapper) {
		this.mapper = mapper;
	}
}
