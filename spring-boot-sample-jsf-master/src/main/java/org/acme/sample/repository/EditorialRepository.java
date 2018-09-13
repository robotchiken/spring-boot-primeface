package org.acme.sample.repository;

import java.util.List;

import org.acme.sample.model.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface EditorialRepository extends JpaRepository<Editorial, Integer> {
		Editorial findByNombre(String nombre);
		@Query(value="SELECT e.nombre FROM Editorial e")
		List<String>getListadoEditoriales();
}
