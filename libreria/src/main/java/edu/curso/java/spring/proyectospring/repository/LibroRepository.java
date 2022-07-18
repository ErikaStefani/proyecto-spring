package edu.curso.java.spring.proyectospring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.curso.java.spring.proyectospring.bo.Libro;


@Repository
public interface LibroRepository extends JpaRepository<Libro,Long> {
	
	
	@Query("select l.nombre from Libro l where l.nombre like ?1%")
    Libro recuperarLibroPorNombre(String nombre);
	
	@Query("select l from Libro as l where l.temaLibro.id=?1")
	List<Libro>recuperarLibroPorPorIdTema(Long id);
	
	@Query("select l from Libro as l where l.edad=?1")
	List<Libro>recuperarLibrosPorEdad(Long edad);
	
	@Query("select l from Libro as l")
	List<Libro>recuperarTodosLosLibros();
	
	@Query("select l from Libro as l where l.temaLibro.id=?1")
	List<Libro>recuperarLibrosPorTema(Long id);
	
	Libro findFirstById(Long codigo);
	
}
                                                        