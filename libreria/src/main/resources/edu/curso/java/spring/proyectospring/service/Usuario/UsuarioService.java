package edu.curso.java.spring.proyectospring.service.Usuario;

import java.util.List;

import edu.curso.java.spring.proyectospring.bo.RolUsuario;
import edu.curso.java.spring.proyectospring.bo.Usuario;

public interface UsuarioService {
	
	public Long guardarNuevoUsuario(Usuario usuario,Long idRol) throws UsuarioException;

	public Usuario buscarUsuarioPorId(Long id);

	public List<Usuario> recuperarUsuarios();
	
	public void borrarUsuarioPorId(Long id);
	
	public void actualizarUsuario(Usuario usuario);
	
	public List<RolUsuario>recuperarRolesUsuarios();
	
	public RolUsuario buscarRolUsuarioPorId(Long id);
	
	public List <Usuario> buscarUsuarios(String nombre);

	public List<Usuario>recuperarUsuariosPorRol(Long id);



}
