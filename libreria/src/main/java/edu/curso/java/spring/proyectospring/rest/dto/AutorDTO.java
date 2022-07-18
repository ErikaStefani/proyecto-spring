package edu.curso.java.spring.proyectospring.rest.dto;


import javax.validation.constraints.NotBlank;


import edu.curso.java.spring.proyectospring.bo.Autor;


public class AutorDTO {

	private Long id;
	@NotBlank
	private String nombre;
	@NotBlank
	private String apellido;

	public AutorDTO() {

	}

	public AutorDTO(Autor autor) {
		this.id = autor.getId();
		this.nombre = autor.getNombre();
		this.apellido = autor.getApellido();

	}

	public AutorDTO(Long id,String nombre, String apellido) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
	
		
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}