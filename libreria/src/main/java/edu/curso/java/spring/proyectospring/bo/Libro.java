package edu.curso.java.spring.proyectospring.bo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Libro {

	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private Float precio;
	private Long stockActual;
	private Long edad;
	private String descripcion;
	private Long stock;

	//@OneToMany
	//private List<ImagenLibro> imagenes;

	/*
	 * private Long editorialId; private Long temaLibroId; private Long autorId;
	 * private Long matrialId;
	 */

	@ManyToOne 
	private Editorial editorial;
	@ManyToOne 
	private TemaLibro temaLibro;
	@ManyToOne 
	private Autor autor;
	@ManyToOne 
	private Material material;

	//public Libro() {
	//	imagenes = new ArrayList<ImagenLibro>();
	//}
	
	public Libro() {
		
	}


	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	public TemaLibro getTemaLibro() {
		return temaLibro;
	}

	public void setTemaLibro(TemaLibro temaLibro) {
		this.temaLibro = temaLibro;
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

	public Long getStockActual() {
		return stockActual;
	}

	public void setStockActual(Long stockActual) {
		this.stockActual = stockActual;
	}

	public Long getEdad() {
		return edad;
	}

	public void setEdad(Long edad) {
		this.edad = edad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

//	public List<ImagenLibro> getImagenes() {
	//	return imagenes;
	//}

//	public void setImagen(ImagenLibro imagen) {
//		this.imagenes.add(imagen);
//	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

//	public void setImagenes(List<ImagenLibro> imagenes) {
//		this.imagenes = imagenes;
	//}

	/*
	 * public Long getEditorialId() { return editorialId; } public void
	 * setEditorialId(Long editorialId) { this.editorialId = editorialId; } public
	 * Long getTemaLibroId() { return temaLibroId; } public void setTemaLibroId(Long
	 * temaLibroId) { this.temaLibroId = temaLibroId; } public Long getAutorId() {
	 * return autorId; } public void setAutorId(Long autorId) { this.autorId =
	 * autorId; } public Long getMatrialId() { return matrialId; } public void
	 * setMatrialId(Long matrialId) { this.matrialId = matrialId; }
	 */



}
