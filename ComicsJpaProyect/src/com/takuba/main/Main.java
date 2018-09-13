package com.takuba.main;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.eclipse.persistence.indirection.IndirectList;
import org.eclipse.persistence.internal.jpa.metadata.structures.ArrayAccessor;

import com.takuba.repository.ComicsRepository;

import model.Calendario;
import model.Comic;
import model.Periodicidad;
import model.Usuario;

public class Main {
	public static void main(String[] args) {
		ComicsRepository repo = new ComicsRepository();
		//Usuario usuario = repo.buscarUsuario("prueba1u");
		Usuario usuario = repo.buscarUsuario("Tankubetor");
		//System.out.println(usuario);
		/*
		List<Calendario>calendarios=usuario.getCalendarios();
		System.out.println("Total de comics que compra:"+calendarios.size());
		
		calendarios.forEach(new Consumer<Calendario>() {

			@Override
			public void accept(Calendario cal) {
				//System.out.println(cal);		
				System.out.println(String.format("Titulo:%s, Fecha:%tD, Editorial:%s", cal.getComic().getTitulo(),cal.getFechaPublicar(),cal.getComic().getEditorial().getNombre()));
			}
		});
		*/
		usuario.getComics().forEach(new Consumer<Comic>() {

			@Override
			public void accept(Comic comic) {
				System.out.println(String.format("Titulo:%s, Editorial:%s, Periodicidad:%s, Precio:%4.2f", comic.getTitulo(),comic.getEditorial().getNombre(),comic.getPeriodicidad().getDescripcion(),comic.getPrecio()));
				
			}
		});
		
		/*
		Usuario usuarioNuevo = new Usuario();
		usuarioNuevo.setUsuario("Tankubetor");
		usuarioNuevo.setPassword("12345678a");
		repo.guardarUsuario(usuarioNuevo);
		*/
		
		/*
		repo.listarPeriodicidad().forEach(new Consumer<Periodicidad>() {

			@Override
			public void accept(Periodicidad t) {
				System.out.println(t);
			}
		});
		*/
		/*
		Usuario usuario2 = repo.buscarUsuario("Tankubetor");
		List<Comic>listaComics =repo.buscarMultipleComics(Arrays.asList(new Integer(5),new Integer(55),new Integer(20),new Integer(31),new Integer(3))); 
		usuario2.setComics(listaComics);
		repo.guardarUsuario(usuario2);
		*/
	}
}
