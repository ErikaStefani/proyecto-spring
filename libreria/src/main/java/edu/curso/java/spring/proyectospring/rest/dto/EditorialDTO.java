package edu.curso.java.spring.proyectospring.rest.dto;


import javax.validation.constraints.NotBlank;
import edu.curso.java.spring.proyectospring.bo.Editorial;


public class EditorialDTO {

	private Long id;
	@NotBlank
	private String nombre;


	public EditorialDTO() {

	}

	public EditorialDTO(Editorial editorial) {
		this.id = editorial.getId();
		this.nombre = editorial.getNombre();
		
	}

	public EditorialDTO(Long id,String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
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