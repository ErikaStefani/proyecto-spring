package edu.curso.java.spring.proyectospring.mvc.fom;

import javax.validation.constraints.NotBlank;

public class ClienteForm {

	private Long id;
	@NotBlank(message = "Debes especificar el nombre")
	private String nombre;
	@NotBlank(message = "Debes especificar el apellido")
	private String apellido;
	@NotBlank(message = "Debes especificar el telefono")
	private String telefono;
	@NotBlank(message = "Debes especificar el email")
	private String email;
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
}
