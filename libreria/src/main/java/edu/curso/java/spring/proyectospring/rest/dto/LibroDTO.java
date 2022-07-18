package edu.curso.java.spring.proyectospring.rest.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import edu.curso.java.spring.proyectospring.bo.Libro;

public class LibroDTO {

	private Long id;
	@NotBlank
	private String nombre;
	@Positive
	private Float precio;
	@Positive
	private Long edad;
	private Long stockActual;
	@NotBlank
	private String descripcion;
	private Long temaId;
	private String temaNombre;
	private Long materialId;
	private String materialNombre;
	private Long autorId;
	private String autorNombre;
	private Long editorialId;
	private String editorialNombre;
	
	private List<ImagenDTO> imagenes; 

	public String getTemaNombre() {
		return temaNombre;
	}

	public void setTemaNombre(String temaNombre) {
		this.temaNombre = temaNombre;
	}

	public String getMaterialNombre() {
		return materialNombre;
	}

	public void setMaterialNombre(String materialNombre) {
		this.materialNombre = materialNombre;
	}

	public String getAutorNombre() {
		return autorNombre;
	}

	public void setAutorNombre(String autorNombre) {
		this.autorNombre = autorNombre;
	}

	public String getEditorialNombre() {
		return editorialNombre;
	}

	public void setEditorialNombre(String editorialNombre) {
		this.editorialNombre = editorialNombre;
	}

	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}

	public void setEditorialId(Long editorialId) {
		this.editorialId = editorialId;
	}

	public Long getAutorId() {
		return autorId;
	}

	public void setAutorId(Long autorId) {
		this.autorId = autorId;
	}

	public Long getEditorialId() {
		return editorialId;
	}

	public void setEditorial(Long editorialId) {
		this.editorialId = editorialId;
	}

	public LibroDTO() {

	}

	public LibroDTO(Libro libro) {
		this.id = libro.getId();
		this.nombre = libro.getNombre();
		this.precio = libro.getPrecio();
		this.edad = libro.getEdad();
		this.stockActual = libro.getStockActual();
		this.descripcion = libro.getDescripcion();
		
		if (libro.getTemaLibro() != null) {
			this.temaId = libro.getTemaLibro().getId();
			this.temaNombre = libro.getTemaLibro().getNombre();
		}
		if (libro.getMaterial() != null) {
			this.materialId = libro.getMaterial().getId();
			this.materialNombre = libro.getMaterial().getNombreMaterial();
		}

		if (libro.getAutor() != null) {
			this.autorId = libro.getAutor().getId();
			this.autorNombre = libro.getAutor().getNombre();
		}

		if (libro.getEditorial() != null) {
			this.editorialId = libro.getEditorial().getId();
			this.editorialNombre = libro.getEditorial().getNombre();
		}

	}

	public LibroDTO(Long id, String nombre, Float precio, Long edad, String temaNombre, String descripcion,
			String materialNombre, String editorialNombre, String autorNombre) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.edad = edad;
		this.descripcion = descripcion;
		this.materialNombre = materialNombre;
		this.editorialNombre = editorialNombre;
		this.autorNombre = autorNombre;
		this.temaNombre = temaNombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Long getEdad() {
		return edad;
	}

	public void setEdad(Long edad) {
		this.edad = edad;
	}

	public Long getTemaId() {
		return temaId;
	}

	public void setTemaId(Long temaId) {
		this.temaId = temaId;
	}

	public Long getStockActual() {
		return stockActual;
	}

	public void setStockActual(Long stockActual) {
		this.stockActual = stockActual;
	}

	public Long getMaterialId() {
		return materialId;
	}

	public void setMaterial(Long materialId) {
		this.materialId = materialId;
	}

	public List<ImagenDTO> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<ImagenDTO> imagenes) {
		this.imagenes = imagenes;
	}

	
}
