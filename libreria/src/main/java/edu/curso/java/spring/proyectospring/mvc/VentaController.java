package edu.curso.java.spring.proyectospring.mvc;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.curso.java.spring.proyectospring.bo.Cliente;
import edu.curso.java.spring.proyectospring.bo.Libro;
import edu.curso.java.spring.proyectospring.bo.Venta;
import edu.curso.java.spring.proyectospring.bo.VentaDetalle;
import edu.curso.java.spring.proyectospring.mvc.fom.VentaDetalleForm;
import edu.curso.java.spring.proyectospring.mvc.fom.VentaForm;
import edu.curso.java.spring.proyectospring.service.Cliente.ClienteService;
import edu.curso.java.spring.proyectospring.service.Libro.LibroService;
import edu.curso.java.spring.proyectospring.service.Venta.VentaService;

@Controller
@RequestMapping("/ventas")
public class VentaController {

	private static Logger log = LoggerFactory.getLogger(VentaController.class);

	@Autowired
	VentaService ventaService;

	@Autowired
	ClienteService clienteService;

	@Autowired
	LibroService libroService;

	@PostMapping("/guardar")
	public String guardarVenta(@Valid  @RequestBody VentaForm ventaForm,
			BindingResult bindingResult, Model model) {

		log.info("VENTA FORM: " + ventaForm.getClienteId());
		log.info("Ejecutando el guardar: " + bindingResult.hasErrors());

		if (bindingResult.hasErrors()) {
//			this.cargarClientes(model);
//			this.cargarLibros(model);
//			model.addAttribute("ventaForm", ventaForm);
//			return "/ventas/ventasForm";
			bindingResult.getAllErrors();
		}

		Venta venta = new Venta();
		venta.setFecha(new Date());
		
		for (VentaDetalleForm detalleForm : ventaForm.getDetalles()) {
			VentaDetalle detalle = new VentaDetalle();
			detalle.setPrecio(detalleForm.getPrecio());
			detalle.setCantidad(detalleForm.getCantidad());
			Libro libro = libroService.buscarLibroPorId(detalleForm.getLibroId());
			detalle.setLibro(libro);
			detalle.setVenta(venta);
			venta.setVentaDetalle(detalle);
		}

		try {
			ventaService.registrarNuevaVenta(venta, ventaForm.getClienteId());
		} catch (Exception e) {
			log.error("Error al gurdar una nueva venta", e.getMessage());

		}

		return "redirect:/ventas";
	}

	@GetMapping
	public String cargarVenta(Model model) {
		this.cargarClientes(model);
		this.cargarLibros(model);
		model.addAttribute("ventaForm", new VentaForm());
		return "/ventas/ventasForm";
	}

	private void cargarClientes(Model model) {
		List<Cliente> cliente = clienteService.buscarTodosLosClientes();
		model.addAttribute("clientes", cliente);
	}

	private void cargarLibros(Model model) {
		List<Libro> libro = libroService.buscarTodosLosLibros();
		model.addAttribute("libros", libro);
	}
}
