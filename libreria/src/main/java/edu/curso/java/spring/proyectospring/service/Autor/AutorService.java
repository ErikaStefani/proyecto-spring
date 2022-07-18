package edu.curso.java.spring.proyectospring.service.Autor;

import java.util.List;

import edu.curso.java.spring.proyectospring.bo.Autor;


public interface AutorService {
	
	public List<Autor> recuperarAutores();
	
	public Autor recuperarAutoresPorId(Long id);

}
