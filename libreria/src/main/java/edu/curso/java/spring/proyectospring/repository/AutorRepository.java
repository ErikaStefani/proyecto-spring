package edu.curso.java.spring.proyectospring.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.curso.java.spring.proyectospring.bo.Autor;


@Repository
public interface AutorRepository extends JpaRepository<Autor, Serializable> {

	
	Autor findById(Long id);
	 
	List<Autor>findAll();

}
