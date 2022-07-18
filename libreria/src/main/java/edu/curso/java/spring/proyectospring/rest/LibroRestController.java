package edu.curso.java.spring.proyectospring.rest;


import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import edu.curso.java.spring.proyectospring.bo.Libro;

import edu.curso.java.spring.proyectospring.bo.TemaLibro;

import edu.curso.java.spring.proyectospring.rest.dto.LibroDTO;
import edu.curso.java.spring.proyectospring.service.Libro.LibroException;
import edu.curso.java.spring.proyectospring.service.Libro.LibroService;

@CrossOrigin
@RestController()
@RequestMapping("/api")
public class LibroRestController {

	@Autowired(required = true)
	private LibroService libroService;

	private static Logger log = LoggerFactory.getLogger(LibroRestController.class);

	@GetMapping("/libros")
	public List<LibroDTO> obtenerTodosLosLibros() {
		List<Libro> libros = libroService.buscarTodosLosLibros();
		List<LibroDTO> librosDTO = new ArrayList<LibroDTO>();
		for (Libro libro : libros) {
			librosDTO.add(new LibroDTO(libro));
		}

		return librosDTO;
	}

	@GetMapping("/libros/{id}")
	public ResponseEntity<LibroDTO> obtenerLibroPorId(@PathVariable Long id) {
		Libro libro = libroService.buscarLibroPorId(id);
		LibroDTO libroDTO = new LibroDTO(libro);
		return ResponseEntity.ok(libroDTO);
	}

	@PostMapping("/libros")
	public ResponseEntity<LibroDTO> crearNuevoLibro(@Valid @RequestBody LibroDTO libroDTO) {
		Libro libro = new Libro();
		libro.setNombre(libroDTO.getNombre());
		libro.setPrecio(libroDTO.getPrecio());
		libro.setStockActual(libroDTO.getStockActual());
		libro.setEdad(libroDTO.getEdad());
		libro.setDescripcion(libroDTO.getDescripcion());

		Long idGenerado;
		try {
			idGenerado = libroService.guardarNuevoLibro(libro, libroDTO.getTemaId(), libroDTO.getEditorialId(),
					libroDTO.getAutorId(), libroDTO.getMaterialId());
			libroDTO.setId(idGenerado);
		} catch (LibroException e) {
			log.error("Error al dar de alta el nuevo libro", e);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(libroDTO);
	}

	@PutMapping("/libros/{id}")
	public void actualizarLibro(@PathVariable Long id, @Valid @RequestBody LibroDTO libroDTO) {
		Libro libro = libroService.buscarLibroPorId(id);
		libro.setNombre(libroDTO.getNombre());
		libro.setPrecio(libroDTO.getPrecio());
		libro.setStockActual(libroDTO.getStockActual());
		libro.setEdad(libroDTO.getEdad());
		libro.setDescripcion(libroDTO.getDescripcion());
		
		libroService.actualizarLibro(libro, libroDTO.getTemaId(), libroDTO.getEditorialId(),
				libroDTO.getAutorId(), libroDTO.getMaterialId());
	}

	@DeleteMapping("/libros/{id}")
	public ResponseEntity<?> borrarLibroPorId(@PathVariable Long id) {
		libroService.borrarLibroPorId(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
	}

	//@GetMapping("/libros/tema/{id}")
	public List<LibroDTO> buscarLibrosPorTema(@PathVariable Long id) {
		TemaLibro temaLibro = libroService.buscarTemaLibroPorId(id);
		log.info("Tema encontrada: " + temaLibro);

		if (temaLibro == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No podemos buscar libros con el tema id: " + id);

		List<Libro> libros = libroService.recuperarLibrosPorTema(id);
		List<LibroDTO> librosDTO = new ArrayList<LibroDTO>();
		for (Libro libro : libros) {
			librosDTO.add(new LibroDTO(libro));
		}

		return librosDTO;
	}

	@GetMapping("/libros/nombre/{nombre}")
	public LibroDTO buscarLibroPorNombre(@PathVariable String nombre) {
		Libro libro = libroService.buscarLibroPorNombre(nombre);

		if (libro == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"No podemos buscar libros con el nombre: " + nombre);
		}

		LibroDTO libroDTO = new LibroDTO(libro);
		return libroDTO;
	}

	/*
	 * @GetMapping("/libros/tema/{id}") public List<LibroDTO>
	 * buscarLibrosPorMaterial(@PathVariable Long id) { Material materialLibro =
	 * libroService.buscarLibroPorIdMaterial(id); log.info("Material encontrado: " +
	 * materialLibro);
	 * 
	 * if (materialLibro == null) throw new
	 * ResponseStatusException(HttpStatus.NOT_FOUND,
	 * "No podemos buscar libros con el tema id: " + id);
	 * 
	 * List<Libro> libros = libroService.recuperarLibrosPorMaterial(id);
	 * List<LibroDTO> librosDTO = new ArrayList<LibroDTO>(); for (Libro libro :
	 * libros) { librosDTO.add(new LibroDTO(libro)); }
	 * 
	 * return librosDTO; }
	 */

}
