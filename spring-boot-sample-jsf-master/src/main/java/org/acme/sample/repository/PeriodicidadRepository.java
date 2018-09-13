package org.acme.sample.repository;

import java.util.List;

import org.acme.sample.model.Periodicidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PeriodicidadRepository extends JpaRepository<Periodicidad, Integer> {
	Periodicidad findByDescripcion(String descripcion);
	@Query(value="SELECT p.* FROM PERIODICIDAD p, COMIC c WHERE p.ID_PERIODICIDAD = c.ID_PERIODICIDAD AND c.ID_COMIC = :idComic",nativeQuery=true)
	Periodicidad buscarPeriodicidad(@Param("idComic")Integer idComic);
	
	@Query(value="SELECT p.descripcion FROM Periodicidad p")
	List<String>getListaPeriodicidad();
}
