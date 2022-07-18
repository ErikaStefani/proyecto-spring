package edu.curso.java.spring.proyectospring.bo;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class Autor {

	@Id
	@GeneratedValue
	private Long id;
	@NotNull(message = "Debes especificar el nombre")
	private String nombre;
	@NotNull(message = "Debes especificar el apellido")
	private String apellido;
	
	//@OneToMany(mappedBy="autor")
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/*public List<Libro> getLibros() {
		return libros;
	}
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	*/
}
