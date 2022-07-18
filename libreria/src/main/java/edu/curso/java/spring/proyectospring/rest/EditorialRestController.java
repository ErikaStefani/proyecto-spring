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

import edu.curso.java.spring.proyectospring.bo.Editorial;

import edu.curso.java.spring.proyectospring.rest.dto.EditorialDTO;
import edu.curso.java.spring.proyectospring.service.Editorial.EditorialService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class EditorialRestController {
	
	@Autowired
	EditorialService editorialService;
	
	@GetMapping("/editoriales")
	public List<EditorialDTO> obtenerTodosLosAutores() {
		List<Editorial> editoriales = editorialService.recuperarTodosLasEditoriales();
		List<EditorialDTO> editorialesDTO = new ArrayList<EditorialDTO>();
		for (Editorial editorial : editoriales) {
			editorialesDTO.add(new EditorialDTO(editorial));
		}

		return editorialesDTO;
	}

	@GetMapping("/editoriales/{id}")
	public ResponseEntity<EditorialDTO> recuperarEditorialPorId(@PathVariable Long id) {
		Editorial editorial = editorialService.recuperarEditorialPorId(id);
		EditorialDTO editorialDTO = new EditorialDTO(editorial);
		return ResponseEntity.ok(editorialDTO);
	}
}
