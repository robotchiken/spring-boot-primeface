package com.takuba.comics.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.takuba.comics.dao.model.Editoriale;

public interface EditorialRepository extends JpaRepository<Editoriale, Integer> {
	Editoriale findId(Integer id);
}
