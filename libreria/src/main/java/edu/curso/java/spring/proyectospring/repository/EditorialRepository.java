package edu.curso.java.spring.proyectospring.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.curso.java.spring.proyectospring.bo.Editorial;


@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Serializable> {
	
	Editorial findById(Long id);
	
	List<Editorial>findAll();

}
