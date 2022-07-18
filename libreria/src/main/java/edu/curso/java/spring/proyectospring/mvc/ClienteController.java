package edu.curso.java.spring.proyectospring.mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.curso.java.spring.proyectospring.bo.Cliente;
import edu.curso.java.spring.proyectospring.mvc.fom.ClienteForm;
import edu.curso.java.spring.proyectospring.service.Cliente.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	private static Logger log = LoggerFactory.getLogger(ClienteController.class);

	@Autowired
	private ClienteService clienteService;

	@GetMapping("/{id}")
	public String verCliente(Model model, @PathVariable Long id) {
		Cliente cliente = clienteService.buscarClientePorId(id);
		model.addAttribute("cliente", cliente);
		return "/clientes/verCliente";
	}
	
	@GetMapping("/agregar")
	public String agregarCliente(Model model) {
	    model.addAttribute("clienteForm", new ClienteForm());
	    return "clientes/clienteForm";
	}
	
	@GetMapping("/{id}/borrar")
	public String borrarClientes(Model model, @PathVariable Long id) {
		clienteService.borrarClientePorId(id);
		return "redirect:/clientes";
	}
	
	@GetMapping
	public String listarClientes(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		log.info("Mi session ID: " + session.getId());
		// session.setAttribute("texto", "Juan " + new Date());
		String texto = (String) session.getAttribute("texto");
		List<Cliente> clientes = clienteService.buscarTodosLosClientes();
		model.addAttribute("clientes", clientes);
		return "/clientes/listadoClientes";
	}
	
	@GetMapping("/{id}/editar")
	public String editarCliente(Model model, @PathVariable Long id) {
		
		Cliente cliente = clienteService.buscarClientePorId(id);
		
		ClienteForm clienteForm = new ClienteForm();
		clienteForm.setId(cliente.getId());
		clienteForm.setNombre(cliente.getNombre());
		clienteForm.setApellido(cliente.getApellido());
		clienteForm.setTelefono(cliente.getTelefono());
		clienteForm.setEmail(cliente.getEmail());

		model.addAttribute("clienteForm", clienteForm);
		return "/clientes/clienteForm";
	}
	
	
	@PostMapping("/guardar")
	public String guardar(@Valid @ModelAttribute(name ="libroForm") ClienteForm clienteForm, BindingResult bindingResult, Model model) {

		log.info("Ejecutando el guardar: " + bindingResult.hasErrors());
	
		
		Cliente cliente = null;
		Long idCliente = clienteForm.getId();
		
		if(idCliente == null) {
			cliente = new Cliente();
		} else {
			cliente = clienteService.buscarClientePorId(idCliente);
		}
		
		cliente.setNombre(clienteForm.getNombre());
		cliente.setApellido(clienteForm.getApellido());
		cliente.setTelefono(clienteForm.getTelefono());
		cliente.setEmail(clienteForm.getEmail());
		
	
		if(idCliente == null) {
			try {
				clienteService.guardarNuevoCliente(cliente);
			} catch (Exception e) {
				log.error("Error al gurdar un nuevo cliente", e.getMessage());
				return "redirect:/error";
			}

		} else {
			clienteService.actualizarCliente(cliente);
		}
		

		return "redirect:/clientes";
	}

	


}
