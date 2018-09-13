package com.takuba.comics.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.takuba.comics.dao.model.Peridiocidad;

public interface PeriodicidadRepository extends JpaRepository<Peridiocidad, Integer> {
	Peridiocidad findId(Integer id);
}
