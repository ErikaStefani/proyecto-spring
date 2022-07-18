package edu.curso.java.spring.proyectospring.service.Cliente;

public class ClienteException extends Exception {
	
	public ClienteException() {
		super();
	}
	public ClienteException(String mensaje) {
		super(mensaje);
	}
	
	public ClienteException(String mensaje,Throwable throwable) {
		super(mensaje,throwable);
	}

}