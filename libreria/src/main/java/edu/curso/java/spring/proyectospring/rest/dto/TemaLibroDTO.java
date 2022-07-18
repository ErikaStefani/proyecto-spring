package edu.curso.java.spring.proyectospring.rest.dto;


import edu.curso.java.spring.proyectospring.bo.TemaLibro;

public class TemaLibroDTO {
	
	private Long id;
	private String nombre;

	public TemaLibroDTO() {
		
	}

	public TemaLibroDTO(TemaLibro temaLibro) {
		this.id = temaLibro.getId();
		this.nombre = temaLibro.getNombre();
	}

	

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

}