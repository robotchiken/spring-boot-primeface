package com.takuba.comics.dao.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.takuba.comics.dao.model.Paquete;

public interface PaqueteRepository extends JpaRepository<Paquete, Integer> {
	Paquete findByPaquete(String paquete);
	
	List<Paquete>findByPaqueteStartingWith(String paquete);
	
	List<Paquete>findByDescripcionStartingWith(String descripcion);
}
