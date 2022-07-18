package edu.curso.java.spring.proyectospring.rest;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import edu.curso.java.spring.proyectospring.bo.Cliente;
import edu.curso.java.spring.proyectospring.rest.dto.ClienteDTO;
import edu.curso.java.spring.proyectospring.service.Cliente.ClienteService;


@CrossOrigin
@RestController()
@RequestMapping("/api")
public class ClienteRestController {

	@Autowired
	private ClienteService clienteService;

	private static Logger log = LoggerFactory.getLogger(LibroRestController.class);

	@GetMapping("/clientes")
	public List<ClienteDTO> obtenerTodosLosClientes() {
		List<Cliente> clientes = clienteService.buscarTodosLosClientes();
		List<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();
		for (Cliente cliente : clientes) {
			clientesDTO.add(new ClienteDTO(cliente));
		}

		return clientesDTO;
	}

	@GetMapping("/clientes/{id}")
	public ResponseEntity<ClienteDTO> obtenerClientePorId(@PathVariable Long id) {
		Cliente cliente = clienteService.buscarClientePorId(id);
		ClienteDTO clienteDTO = new ClienteDTO(cliente);
		return ResponseEntity.ok(clienteDTO);
	}

	@PostMapping("/clientes")
	public ResponseEntity<ClienteDTO> crearNuevoCliente(@Valid @RequestBody ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
		cliente.setNombre(clienteDTO.getNombre());
		cliente.setApellido(clienteDTO.getApellido());
		cliente.setTelefono(clienteDTO.getTelefono());
		cliente.setEmail(clienteDTO.getEmail());
		clienteService.guardarNuevoCliente(cliente);
			
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteDTO);
	}

	@PutMapping("/clientes/{id}")
	public void actualizarCliente(@PathVariable Long id, @Valid @RequestBody ClienteDTO clienteDTO) {
		Cliente cliente = clienteService.buscarClientePorId(id);
		cliente.setNombre(clienteDTO.getNombre());
		cliente.setApellido(clienteDTO.getApellido());
		cliente.setTelefono(clienteDTO.getTelefono());
		cliente.setEmail(clienteDTO.getEmail());
		
		clienteService.actualizarCliente(cliente);
	}

	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<?> borrarClientePorId(@PathVariable Long id) {
		clienteService.borrarClientePorId(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
	}

	
	@GetMapping("/clientes/nombre/{nombre}")
	public ClienteDTO buscarClientePorNombre(@PathVariable String nombre) {
		Cliente cliente = clienteService.buscarClientePorNombre(nombre);

		if (cliente == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"No podemos buscar libros con el nombre: " + nombre);
		}

		ClienteDTO clienteDTO = new ClienteDTO(cliente);
		return clienteDTO;
	}
	
}
