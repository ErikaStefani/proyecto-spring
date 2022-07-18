package edu.curso.java.spring.proyectospring.rest.dto;

import java.util.Date;

import edu.curso.java.spring.proyectospring.bo.Libro;
import edu.curso.java.spring.proyectospring.bo.Venta;

public class VentaDTO {

	private Long idVenta;
	private Date fecha;
	private Long idCliente;
	private Long idVentaDetalle;

	private String nombre;

	public VentaDTO() {

	}

	public VentaDTO(Venta venta) {

	}

	public VentaDTO(Long idVenta, Date fecha, Long idCliente, Long idVentaDetalle) {
		super();
		this.idVenta = idVenta;
		this.fecha = fecha;
		this.idCliente = idCliente;
		this.idVentaDetalle = idVentaDetalle;
	}

	public Long getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Long idVenta) {
		this.idVenta = idVenta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Long getIdVentaDetalle() {
		return idVentaDetalle;
	}

	public void setIdVentaDetalle(Long idVentaDetalle) {
		this.idVentaDetalle = idVentaDetalle;
	}

}
