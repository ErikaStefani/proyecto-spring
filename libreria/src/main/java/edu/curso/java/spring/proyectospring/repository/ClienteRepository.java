package edu.curso.java.spring.proyectospring.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.curso.java.spring.proyectospring.bo.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Serializable> {

	Cliente findById(Long id);

    List<Cliente> findAll();

    @Query("select c.nombre from Cliente c where c.nombre like ?1%")
    Cliente recuperarClientePorNombre(String nombre);

}