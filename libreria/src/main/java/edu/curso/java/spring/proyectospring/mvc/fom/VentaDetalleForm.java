package edu.curso.java.spring.proyectospring.mvc.fom;

import javax.validation.constraints.Positive;

public class VentaDetalleForm {

	@Positive 
	private Long cantidad;
	@Positive
	private Double precio;
	private Long libroId;
	
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Long getLibroId() {
		return libroId;
	}
	public void setLibroId(Long libroId) {
		this.libroId = libroId;
	}
}
