package com.takuba.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Comic;
import model.Periodicidad;
import model.Usuario;

public class ComicsRepository {
	private final String PERSISTENCE_UNIT_NAME = "ComicsJpaProyect";
	private EntityManagerFactory factory;
	EntityManager em;
	public ComicsRepository(){
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();
	}
	public Usuario buscarUsuario(String usuario){
		return em.createNamedQuery("Usuario.findUsuario",Usuario.class).setParameter("usuario", usuario).getSingleResult();
	}
	public List<Periodicidad>listarPeriodicidad(){
		return em.createNamedQuery("Periodicidad.findAll",Periodicidad.class).getResultList();
	}
	public void guardarUsuario(Usuario usuario){
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(usuario);
		transaction.commit();		
	}
	
	public List<Comic> buscarMultipleComics(List<Integer>listComics){
		return em.createNamedQuery("Comic.findByMultipleId",Comic.class).setParameter("titulos", listComics).getResultList();
	}
	
}
