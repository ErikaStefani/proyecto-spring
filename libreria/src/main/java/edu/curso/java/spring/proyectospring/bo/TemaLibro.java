package edu.curso.java.spring.proyectospring.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class TemaLibro {
	@Id 
	@GeneratedValue
	private Long id;
	private String nombre;
	
	//@OneToMany(mappedBy="temaLibro")
	//private List<Libro> libros;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
/*	public List<Libro> getLibros() {
		return libros;
	}
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	*/
}
