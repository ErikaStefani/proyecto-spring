package edu.curso.java.spring.proyectospring.rest;

import java.security.Principal;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserRestController {

	@GetMapping("/autenticar")
	public Principal user(Principal principal) {
		return principal;
	}
}
