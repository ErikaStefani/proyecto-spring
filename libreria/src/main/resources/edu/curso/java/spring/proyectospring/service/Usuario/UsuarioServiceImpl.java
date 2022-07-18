package edu.curso.java.spring.proyectospring.service.Usuario;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.java.spring.proyectospring.bo.RolUsuario;
import edu.curso.java.spring.proyectospring.bo.Usuario;

import edu.curso.java.spring.proyectospring.repository.RolUsuarioRepository;
import edu.curso.java.spring.proyectospring.repository.UsuarioRepository;

import org.springframework.cache.annotation.Cacheable;


import java.util.*;



@Service
@Transactional(rollbackFor = Exception.class)
public class UsuarioServiceImpl implements UsuarioService {

	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private RolUsuarioRepository rolUsuarioRepository;


	@Override
	@PreAuthorize("hasRole('ADMIN')")
	public Long guardarNuevoUsuario(Usuario usuario, Long rolId) throws UsuarioException {
		RolUsuario rolUsuario = rolUsuarioRepository.findById(rolId);
		usuario.setRolUsuario(rolUsuario);
		usuarioRepository.save(usuario);

		//if (producto.getStockActual() == 0) {
		//throw new UsuarioException("No se puede guardar un producto con stock 0");
		//}
		

		return usuario.getId();
	}
	
	
	
	

	@Override
	public Usuario buscarUsuarioPorId(Long id) {
		Optional<Usuario> ususarioOptional = usuarioRepository.findById(id);
		return ususarioOptional.get();
	}

	@Override
	public List<Usuario> recuperarUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public void borrarUsuarioPorId(Long id) {

		usuarioRepository.deleteById(id);
	}

	@Override
	public void actualizarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	@Override
	@Cacheable("roles")
	public List<RolUsuario> recuperarRolesUsuarios() {
		return rolUsuarioRepository.findAll();
	}

	@Cacheable("rolesPorId")
	@Override
	public RolUsuario buscarRolUsuarioPorId(Long id) {
		return rolUsuarioRepository.findById(id);
	}

	@Override
	public List<Usuario> buscarUsuarios(String nombre) {
		return usuarioRepository.buscarUsuario(nombre);
	}


	@Override
	public List<Usuario> recuperarUsuariosPorRol(Long id) {
		return usuarioRepository.recuperarUsuariosPorRol(id);

	}


}
