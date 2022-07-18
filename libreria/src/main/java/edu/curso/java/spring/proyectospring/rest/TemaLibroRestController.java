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

import edu.curso.java.spring.proyectospring.bo.TemaLibro;
import edu.curso.java.spring.proyectospring.rest.dto.TemaLibroDTO;

import edu.curso.java.spring.proyectospring.service.TemaLibro.TemaLibroService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TemaLibroRestController {

	@Autowired
	private TemaLibroService temaLibroService;
	
	@GetMapping("/temas")
	public List<TemaLibroDTO> recuperarTodosLosTemas() {
		List<TemaLibro> temas = temaLibroService.recuperarTemasLibro();
		List<TemaLibroDTO> temasDTO = new ArrayList<TemaLibroDTO>();
		for (TemaLibro temaLibro : temas) {
			temasDTO.add(new TemaLibroDTO(temaLibro));
		}

		return temasDTO;
	}

	@GetMapping("/temas/{id}")
	public ResponseEntity<TemaLibroDTO> recuperarTemaPorId(@PathVariable Long id) {
		TemaLibro temaLibro = temaLibroService.recuperarTemaLibroPorId(id);
		TemaLibroDTO libroDTO = new TemaLibroDTO(temaLibro);
		return ResponseEntity.ok(libroDTO);
	}

}