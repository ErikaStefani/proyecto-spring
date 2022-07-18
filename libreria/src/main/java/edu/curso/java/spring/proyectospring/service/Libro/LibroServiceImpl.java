package edu.curso.java.spring.proyectospring.service.Libro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.java.spring.proyectospring.bo.Autor;
import edu.curso.java.spring.proyectospring.bo.Editorial;
import edu.curso.java.spring.proyectospring.bo.ImagenLibro;
import edu.curso.java.spring.proyectospring.bo.Libro;
import edu.curso.java.spring.proyectospring.bo.Material;
import edu.curso.java.spring.proyectospring.bo.TemaLibro;
import edu.curso.java.spring.proyectospring.repository.AutorRepository;
import edu.curso.java.spring.proyectospring.repository.EditorialRepository;
import edu.curso.java.spring.proyectospring.repository.LibroRepository;
import edu.curso.java.spring.proyectospring.repository.TemaLibroRepository;
import edu.curso.java.spring.proyectospring.repository.MaterialRepository;

import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

@Service
@Transactional(rollbackFor=Exception.class)
public class LibroServiceImpl implements LibroService {

	@Autowired
	private LibroRepository libroRepository;
	
	@Autowired
	private MaterialRepository materialRepository;

	@Autowired
	private TemaLibroRepository temaLibroRepository;
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private EditorialRepository editorialRepository;
	
	@Override
	public Long guardarNuevoLibro(Libro libro, Long temaId, Long editorialId, Long autorId, Long materialId) throws LibroException {
		
		if(libro.getStockActual() == 0) {
			throw new LibroException("No se puede guardar un producto con stock 0");
		}
		
		if(libro.getPrecio() <= 0) {
			throw new LibroException("No se puede guardar un libro con precio menor o igual a 0");
		}
		
		
		TemaLibro temaLibro = temaLibroRepository.findById(temaId);
		libro.setTemaLibro(temaLibro);
		
		Material material = materialRepository.findById(materialId);
		libro.setMaterial(material);
		
		Autor autor = autorRepository.findById(autorId);
		libro.setAutor(autor);
		
		Editorial editorial = editorialRepository.findById(editorialId);
		libro.setEditorial(editorial);
		
		libroRepository.save(libro);
		
		
		return libro.getId();
	}
	
	@Override
	public void actualizarLibro(Libro libro, Long temaId, Long editorialId, Long autorId, Long materialId) {
		TemaLibro temaLibro = temaLibroRepository.findById(temaId);
		libro.setTemaLibro(temaLibro);
		
		Material material = materialRepository.findById(materialId);
		libro.setMaterial(material);
		
		Autor autor = autorRepository.findById(autorId);
		libro.setAutor(autor);
		
		Editorial editorial = editorialRepository.findById(editorialId);
		libro.setEditorial(editorial);
		
		/*for (ImagenLibro imagen : libro.getImagenes()) {
			try
	        {
				String imageDataBytes = imagen.getFileContent().substring(imagen.getFileContent().indexOf(",")+1);
				// decode the string and write to file
		        byte[] decodedBytes = Base64
		          .getDecoder()
		          .decode(imageDataBytes);
		        
		        
	        }
	        catch(Exception e)
	        {
	            
	        }
		}*/
		
		libroRepository.save(libro);
	}
	
	@Override
	public Libro buscarLibroPorId(Long id) {
		Optional<Libro> libroOptional = libroRepository.findById(id);
		return libroOptional.get();
	}


	@Override
	public void borrarLibroPorId(Long id) {
		libroRepository.deleteById(id);
	}


	
	@Override
	public List<Libro> buscarTodosLosLibros() {
		return libroRepository.recuperarTodosLosLibros();
	}

	@Cacheable("temasLibro")
	@Override
	public List<Libro> recuperarLibrosPorTema(Long id) {
		return libroRepository.recuperarLibrosPorTema(id);
	}

	@Cacheable("temasLibroPorId")
	@Override
	public TemaLibro buscarTemaLibroPorId(Long id) {
		return temaLibroRepository.findById(id);
	}
	

	@Override
	public Libro buscarLibroPorNombre(String nombre) {
		return libroRepository.recuperarLibroPorNombre(nombre);
	}

	/*
	@Cacheable("materiales")
	@Override
	public List<Libro> recuperarLibrosPorMaterial(Long id) {
		return libroRepository.recuperarLibrosPorMaterial(id);
	}

	@Cacheable("materialesPorId")
	@Override
	public Material buscarMaterialPorId(Long id) {
		return materialRepository.findById(id);
	}
	
	@Cacheable("edades")
	@Override
	public List<Libro> BuscarLibrosPorEdad(Long edad) {
		return libroRepository.recuperarLibrosPorEdad(edad);
		
	}

	@Override
	public List<Libro> BuscarLibrosPorMaterial(String material) {
		return libroRepository.recuperarLibrosPorMaterial(material);
		
	}

*/
	

}
	
