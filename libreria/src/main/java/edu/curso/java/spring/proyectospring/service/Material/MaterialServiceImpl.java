package edu.curso.java.spring.proyectospring.service.Material;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.java.spring.proyectospring.bo.Material;
import edu.curso.java.spring.proyectospring.repository.MaterialRepository;


@Service
@Transactional(rollbackFor = Exception.class)
public class MaterialServiceImpl implements MaterialService {

	@Autowired
	MaterialRepository materialRepository;
	
	@Override
	public List<Material> recuperarTodosLosMateriales() {
		return materialRepository.findAll();
		
	}
	
	@Override
	public Material recuperarMaterialPorId(Long id) {
		return materialRepository.findById(id);
	}

}
