package com.takuba.comics.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.takuba.comics.dao.model.Comic;

public interface ComicRepository extends JpaRepository<Comic, Integer> {
	Comic findByTitulo(String titulo);
	List<Comic> findByNumerofinalGreaterThan(Integer numerofinal);
	List<Comic>findComics();
	Comic buscarComic(String titulo);
}
