package com.takuba.comics.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.takuba.comics.dao.model.Paquete;
import com.takuba.comics.dao.repository.PaqueteRepository;
import com.takuba.comics.exception.PaqueteNotFoundException;

@RestController
public class PaqueteService {
	@Autowired
	private PaqueteRepository repository;
	
	@GetMapping("/paquetes")
	List<Paquete>listarPaquetes(){
		return repository.findAll();
	}
	
	@GetMapping("/buscarPorId/{id}")
	Paquete buscarPorId(@PathVariable int id){
		Optional<Paquete> paquete = repository.findById(id);
		if(!paquete.isPresent()){
			throw new PaqueteNotFoundException("id-"+id);
		}
		return paquete.get(); 
	}
	
	@GetMapping("/buscarPorPaquete/{paquete}")
	Paquete buscarPorPaquete(@PathVariable String paquete){
		Paquete result =repository.findByPaquete(paquete);
		if(result == null){
			throw new PaqueteNotFoundException("paquete:"+paquete);
		}
		return result;
	}
	
	@GetMapping("/buscarPaquete/{paquete}")
	List<Paquete> buscarPaquete(@PathVariable String paquete){
		List<Paquete> listPaquete=repository.findByPaqueteStartingWith(paquete);
		if(listPaquete.size() == 0){
			throw new PaqueteNotFoundException("paquete:"+paquete);
		}
		return listPaquete;
	}
	
	@RequestMapping(value="/buscarDescripcion", method=RequestMethod.POST)
	List<Paquete> buscarPorDescripcion(@Param(value = "descripcion") String descripcion){
		return repository.findByDescripcionStartingWith(descripcion);
	}
	public PaqueteRepository getRepository() {
		return repository;
	}
	public void setRepository(PaqueteRepository repository) {
		this.repository = repository;
	}
	
	
}
