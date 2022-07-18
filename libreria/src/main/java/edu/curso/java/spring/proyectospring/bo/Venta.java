package edu.curso.java.spring.proyectospring.bo;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Venta {

	@Id
	@GeneratedValue
	private Long idVenta;

	private Date fecha;

	@ManyToOne
	@JoinColumn(name = "CLIENTE_ID", nullable = false)
	Cliente cliente;

	@OneToMany(mappedBy = "venta", cascade = CascadeType.PERSIST, orphanRemoval = true)
	private List<VentaDetalle> ventaDetalle;

	public Venta() {
		ventaDetalle = new ArrayList<VentaDetalle>();
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<VentaDetalle> getVentaDetalle() {
		return ventaDetalle;
	}

	public void setVentaDetalle(VentaDetalle ventaDetalle) {
		this.ventaDetalle.add(ventaDetalle);
	}

}
