package edu.curso.java.spring.proyectospring.service.Cliente;



import java.util.List;

import edu.curso.java.spring.proyectospring.bo.Cliente;

public interface ClienteService {
	
	public Cliente buscarClientePorId(Long id);
	
	public List<Cliente> buscarTodosLosClientes();
	
	public Long guardarNuevoCliente(Cliente cliente);
	
	public void actualizarCliente(Cliente cliente);
	
	public void borrarClientePorId(Long id);
	
	public Cliente buscarClientePorNombre(String nombre);

}
