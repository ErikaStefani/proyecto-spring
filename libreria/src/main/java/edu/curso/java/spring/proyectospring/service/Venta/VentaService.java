package edu.curso.java.spring.proyectospring.service.Venta;


import edu.curso.java.spring.proyectospring.bo.Venta;
import edu.curso.java.spring.proyectospring.bo.VentaDetalle;


public interface VentaService {

	public Long registrarNuevaVenta(Venta venta, Long idCliente) throws VentaException;
}
