package edu.curso.java.spring.proyectospring.service.TemaLibro;

import java.util.List;


import edu.curso.java.spring.proyectospring.bo.TemaLibro;

public interface TemaLibroService {
	
	public List<TemaLibro> recuperarTemasLibro();
	
	public TemaLibro recuperarTemaLibroPorId(Long id);

}
