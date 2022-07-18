package edu.curso.java.spring.proyectospring.service.Libro;

import java.util.List;

import edu.curso.java.spring.proyectospring.bo.ImagenLibro;
import edu.curso.java.spring.proyectospring.bo.Libro;
import edu.curso.java.spring.proyectospring.bo.TemaLibro;


public interface LibroService {
	
	public Long guardarNuevoLibro(Libro libro,Long idTema, Long editorialId, Long autorId, Long materialId) throws LibroException;

	public Libro buscarLibroPorId(Long id);

    public void borrarLibroPorId(Long id);
	
	public void actualizarLibro(Libro libro, Long temaId, Long editorialId, Long autorId, Long materialId);
	
	public List<Libro>recuperarLibrosPorTema(Long id);
	
	public TemaLibro buscarTemaLibroPorId(Long id);
	
	public List<Libro>buscarTodosLosLibros();
	
	public Libro buscarLibroPorNombre(String nombre);

    //public List<Libro> recuperarLibrosPorMaterial(Long id); 

     //public Material buscarMaterialPorId(Long id); 
	

}