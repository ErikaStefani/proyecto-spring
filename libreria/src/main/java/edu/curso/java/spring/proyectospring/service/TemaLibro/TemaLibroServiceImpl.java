package edu.curso.java.spring.proyectospring.service.TemaLibro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.java.spring.proyectospring.bo.TemaLibro;
import edu.curso.java.spring.proyectospring.repository.TemaLibroRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class TemaLibroServiceImpl implements TemaLibroService {
	
    @Autowired
	TemaLibroRepository temaLibroRepository;
	
    @Override
	public List<TemaLibro> recuperarTemasLibro() {
		return temaLibroRepository.findAll();
	}

	@Override
	public TemaLibro recuperarTemaLibroPorId(Long id) {
		return temaLibroRepository.findById(id);
	}

}
