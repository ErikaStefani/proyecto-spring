package edu.curso.java.spring.proyectospring.rest.dto;

import javax.validation.constraints.NotBlank;
import edu.curso.java.spring.proyectospring.bo.Material;

public class MaterialDTO {

	private Long id;
	@NotBlank
	private String nombre;

	public MaterialDTO() {

	}

	public MaterialDTO(Material material) {
		this.id = material.getId();
		this.nombre = material.getNombreMaterial();

	}

	public MaterialDTO(Long id, String nombre) {
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