package edu.curso.java.spring.proyectospring.service.Venta;

public class VentaException extends Exception {

	public VentaException() {
		super();
	}
	public VentaException(String mensaje) {
		super(mensaje);
	}
	
	public VentaException(String mensaje,Throwable throwable) {
		super(mensaje,throwable);
	}

}
