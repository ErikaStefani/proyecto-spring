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

import edu.curso.java.spring.proyectospring.bo.Autor;
import edu.curso.java.spring.proyectospring.rest.dto.AutorDTO;
import edu.curso.java.spring.proyectospring.service.Autor.AutorService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class AutorRestController {
	
	@Autowired
	AutorService autorService;
	
	@GetMapping("/autores")
	public List<AutorDTO> obtenerTodosLosAutores() {
		List<Autor> autores = autorService.recuperarAutores();
		List<AutorDTO> autoresDTO = new ArrayList<AutorDTO>();
		for (Autor autor : autores) {
			autoresDTO.add(new AutorDTO(autor));
		}

		return autoresDTO;
	}
	
	@GetMapping("/autores/{id}")
	public ResponseEntity<AutorDTO> recuperarAutorPorId(@PathVariable Long id) {
		Autor autor = autorService.recuperarAutoresPorId(id);
		AutorDTO autorDTO = new AutorDTO(autor);
		return ResponseEntity.ok(autorDTO);
	}

}
