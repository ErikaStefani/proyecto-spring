package edu.curso.java.spring.proyectospring.service.Editorial;

import java.util.List;


import edu.curso.java.spring.proyectospring.bo.Editorial;


public interface EditorialService {
	
	 List<Editorial>recuperarTodosLasEditoriales();
	
	 Editorial recuperarEditorialPorId(Long id);

}
