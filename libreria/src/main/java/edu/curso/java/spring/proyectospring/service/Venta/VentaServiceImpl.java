package edu.curso.java.spring.proyectospring.service.Venta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.java.spring.proyectospring.bo.Autor;
import edu.curso.java.spring.proyectospring.bo.Cliente;
import edu.curso.java.spring.proyectospring.bo.Editorial;
import edu.curso.java.spring.proyectospring.bo.Libro;
import edu.curso.java.spring.proyectospring.bo.Material;
import edu.curso.java.spring.proyectospring.bo.TemaLibro;
import edu.curso.java.spring.proyectospring.bo.Venta;
import edu.curso.java.spring.proyectospring.bo.VentaDetalle;
import edu.curso.java.spring.proyectospring.repository.ClienteRepository;
import edu.curso.java.spring.proyectospring.repository.VentaRepository;
import edu.curso.java.spring.proyectospring.service.Libro.LibroException;

@Service
@Transactional(rollbackFor=Exception.class)
public class VentaServiceImpl implements VentaService{

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	VentaRepository ventaRepository;
	
	@Override
	public Long registrarNuevaVenta(Venta venta, Long idCliente) throws VentaException {
		
		Cliente cliente = clienteRepository.findById(idCliente);
		venta.setCliente(cliente);
		
		ventaRepository.save(venta);
		return venta.getIdVenta();
	}
}
