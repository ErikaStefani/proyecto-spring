package edu.curso.java.spring.proyectospring.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.curso.java.spring.proyectospring.bo.Material;


@Repository
public interface MaterialRepository extends JpaRepository<Material,Serializable> {
	
	Material findById(Long id);
	
	List<Material>findAll();

}
