package edu.curso.java.spring.proyectospring.service.Editorial;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.java.spring.proyectospring.bo.Editorial;
import edu.curso.java.spring.proyectospring.repository.EditorialRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class EditorialServiceImpl implements EditorialService {

	@Autowired
	EditorialRepository editorialRepository;
	@Override
	public List<Editorial> recuperarTodosLasEditoriales() {
		return editorialRepository.findAll();
		
	}
	@Override
	public Editorial recuperarEditorialPorId(Long id) {
		return editorialRepository.findById(id);
	}
	

}
