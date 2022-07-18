package edu.curso.java.spring.proyectospring.service.Material;

import java.util.List;


import edu.curso.java.spring.proyectospring.bo.Material;


public interface MaterialService {
	
	public List<Material>recuperarTodosLosMateriales();
	
	public Material recuperarMaterialPorId(Long id);

}
