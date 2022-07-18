package edu.curso.java.spring.proyectospring.mvc.fom;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class VentaForm {
	
	private Date fecha;
	private Long clienteId;
	private List<VentaDetalleForm> detalles;
	
	public VentaForm() {
		detalles = new ArrayList<VentaDetalleForm>();
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}
	
	public List<VentaDetalleForm> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<VentaDetalleForm> detalles) {
		this.detalles = detalles;
	}

}

