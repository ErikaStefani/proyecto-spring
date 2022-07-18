package edu.curso.java.spring.proyectospring.rest.dto;



public class VentaDetalleDTO {
	
	private Long idDetalle;
	private Long cantidad;
	private Double precio;
	private Long idVenta;
	private Long idLibros;
	
	public VentaDetalleDTO() {
		
	}
	
	public Long getIdDetalle() {
		return idDetalle;
	}
	public void setIdDetalle(Long idDetalle) {
		this.idDetalle = idDetalle;
	}
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
	public Long getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(Long idVenta) {
		this.idVenta = idVenta;
	}
	public Long getIdLibros() {
		return idLibros;
	}
	public void setIdLibros(Long idLibros) {
		this.idLibros = idLibros;
	}
	
	

}
