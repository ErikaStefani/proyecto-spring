package edu.curso.java.spring.proyectospring.mvc.fom;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.web.multipart.MultipartFile;

public class LibroForm {
	
	private Long libroId;
	private Long temaLibroId;
	private Long autorId;
	private Long editorialId;
	private Long materialId;
	
	@NotBlank(message = "Debes especificar el nombre")
	private String nombre;
	@NotNull @Positive
	private Double precio;
	@NotNull @Positive
	private Long stockActual;
	@NotNull @Positive
	private Long edad;
	@NotBlank (message = "Debes especificar la descripcion")
	private String descripcion;
	
	
	private MultipartFile foto;
	
	
	public MultipartFile getFoto() {
		return foto;
	}
	public void setFoto(MultipartFile foto) {
		this.foto = foto;
	}
	public Long getLibroId() {
		return libroId;
	}
	public void setLibroId(Long libroId) {
		this.libroId = libroId;
	}
	public Long getTemaLibroId() {
		return temaLibroId;
	}
	public void setTemaLibroId(Long temaLibroId) {
		this.temaLibroId = temaLibroId;
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
	public void setEditorialId(Long editorialId) {
		this.editorialId = editorialId;
	}
	public Long getMaterialId() {
		return materialId;
	}
	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
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

}