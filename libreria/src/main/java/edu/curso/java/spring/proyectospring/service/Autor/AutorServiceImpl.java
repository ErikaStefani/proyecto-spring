package edu.curso.java.spring.proyectospring.service.Autor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.java.spring.proyectospring.bo.Autor;
import edu.curso.java.spring.proyectospring.repository.AutorRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class AutorServiceImpl implements AutorService {

	@Autowired
	AutorRepository autorRepository;
	
	@Override
	public List<Autor> recuperarAutores() {
		return autorRepository.findAll();
	}

	@Override
	public Autor recuperarAutoresPorId(Long id) {
		return autorRepository.findById(id);
	}

	

}
