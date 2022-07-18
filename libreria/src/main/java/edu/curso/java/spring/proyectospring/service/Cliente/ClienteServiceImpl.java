package edu.curso.java.spring.proyectospring.service.Cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.java.spring.proyectospring.bo.Cliente;


import edu.curso.java.spring.proyectospring.repository.ClienteRepository;



@Service
@Transactional(rollbackFor = Exception.class)
public class ClienteServiceImpl implements ClienteService {
	

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Cliente buscarClientePorId(Long id) {
		return clienteRepository.findById(id);
	}

	@Override
	public List<Cliente> buscarTodosLosClientes() {
		return clienteRepository.findAll();
	}

	@Override
	public Long guardarNuevoCliente(Cliente cliente) {
		clienteRepository.save(cliente);
		return cliente.getId();
	}

	@Override
	public void actualizarCliente(Cliente cliente) {
		clienteRepository.save(cliente);
		
	}

	@Override
	public void borrarClientePorId(Long id) {
		clienteRepository.deleteById(id);
	}

	@Override
	public Cliente buscarClientePorNombre(String nombre) {
		return clienteRepository.recuperarClientePorNombre(nombre);
	}

	



}
