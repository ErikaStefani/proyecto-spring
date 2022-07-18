package edu.curso.java.spring.proyectospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import edu.curso.java.spring.proyectospring.bo.Venta;
@Repository
public interface VentaRepository extends JpaRepository<Venta,Long> {

}
