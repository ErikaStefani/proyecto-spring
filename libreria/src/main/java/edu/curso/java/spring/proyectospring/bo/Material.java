package edu.curso.java.spring.proyectospring.bo;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Material {
	
	@Id
	@GeneratedValue
	private Long id;
	private String nombreMaterial;
	
	//@OneToMany(mappedBy="material")
	//private List<Libro> libros;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombreMaterial() {
		return nombreMaterial;
	}
	public void setNombreMaterial(String nombreMaterial) {
		this.nombreMaterial = nombreMaterial;
	}
	/*public List<Libro> getLibros() {
		return libros;
	}
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	*/
}
