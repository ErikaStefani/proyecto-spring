package edu.curso.java.spring.proyectospring.rest.dto;



import javax.validation.constraints.NotBlank;


import edu.curso.java.spring.proyectospring.bo.Cliente;



public class ClienteDTO {
	
	private Long id;
	@NotBlank
	private String nombre;
	@NotBlank
	private String apellido;
	private String telefono;
	private String email;

	public ClienteDTO() {

	}

	public ClienteDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.nombre = cliente.getNombre();
		this.apellido = cliente.getApellido();
		this.telefono =cliente.getTelefono();
		this.email = cliente.getEmail();
	
 }
	
	public ClienteDTO(Long id,String nombre, String apellido, String telefono, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
	
		
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
