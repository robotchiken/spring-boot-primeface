package org.acme.sample.repository;

import java.math.BigDecimal;
import java.util.List;

import org.acme.sample.model.Calendario;
import org.acme.sample.model.CalendarioPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CalendarioRepository extends JpaRepository<Calendario, CalendarioPK> {
	@Query(value="SELECT * FROM CALENDARIO WHERE ID_USUARIO =:idUsuario",nativeQuery=true)
	List<Calendario> buscarCalendario(@Param("idUsuario") Integer idUsuario);
	@Query(value="SELECT c FROM Calendario c WHERE c.id.idComic=:idComic AND c.id.idUsuario=:idUsuario")
	Calendario buscarEventoUsuario(@Param("idComic") Integer idComic, @Param("idUsuario") Integer idUsuario);
	@Query(value="SELECT SUM(PRECIO) FROM COMIC WHERE ID_COMIC IN(SELECT ID_COMIC FROM CALENDARIO WHERE ID_USUARIO =:idUsuario)",nativeQuery=true)
	BigDecimal calcularTotal(@Param("idUsuario") Integer idUsuario);
}
