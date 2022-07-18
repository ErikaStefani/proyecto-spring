package edu.curso.java.spring.proyectospring.service.Libro;

public class LibroException extends Exception {
	
	public LibroException() {
		super();
	}
	public LibroException(String mensaje) {
		super(mensaje);
	}
	
	public LibroException(String mensaje,Throwable throwable) {
		super(mensaje,throwable);
	}

}
