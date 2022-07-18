package edu.curso.java.spring.proyectospring.repository;
import java.io.Serializable;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import edu.curso.java.spring.proyectospring.bo.TemaLibro;

@Repository
public interface TemaLibroRepository extends JpaRepository<TemaLibro,Serializable> {
	
	 TemaLibro findById(Long id);

	 List<TemaLibro>findAll();
}
