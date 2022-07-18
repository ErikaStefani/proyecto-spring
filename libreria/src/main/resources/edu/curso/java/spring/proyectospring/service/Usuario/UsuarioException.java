package edu.curso.java.spring.proyectospring.service.Usuario;

public class UsuarioException extends Exception {
	
	public UsuarioException() {
		super();
	}
	public UsuarioException(String mensaje) {
		super(mensaje);
	}
	
	public UsuarioException(String mensaje,Throwable throwable) {
		super(mensaje,throwable);
	}

}
