package edu.curso.java.spring.proyectospring.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import edu.curso.java.spring.proyectospring.bo.Material;

import edu.curso.java.spring.proyectospring.rest.dto.MaterialDTO;

import edu.curso.java.spring.proyectospring.service.Material.MaterialService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class MaterialRestController {
	
	@Autowired
	MaterialService materialService;
	
	@GetMapping("/materiales")
	public List<MaterialDTO> obtenerTodosLosMateriales() {
		List<Material> materiales = materialService.recuperarTodosLosMateriales();
		List<MaterialDTO> materialesDTO = new ArrayList<MaterialDTO>();
		for (Material material : materiales) {
			materialesDTO.add(new MaterialDTO(material));
		}

		return materialesDTO;
	}
	
	@GetMapping("/materiales/{id}")
	public ResponseEntity<MaterialDTO> recuperarMaterialPorId(@PathVariable Long id) {
		Material material = materialService.recuperarMaterialPorId(id);
		MaterialDTO materialDTO = new MaterialDTO(material);
		return ResponseEntity.ok(materialDTO);
	}

}
