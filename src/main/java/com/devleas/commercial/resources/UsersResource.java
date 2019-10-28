package com.devleas.commercial.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devleas.commercial.domain.User;
import com.devleas.commercial.services.UsersService;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UsersResource {

	@Autowired
	private UsersService usersService;
	
	@PostMapping
	public ResponseEntity<User> salvar(@Valid @RequestBody User user) {
		user = usersService.salvar(user);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(user.getId()).toUri();
		
		return ResponseEntity.created(uri).body(user);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(usersService.listar());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> buscarPorId(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(usersService.buscarPorId(id));
	}
	
	public User buscarPorUserName(String userName) {
		return usersService.buscarPorUserName(userName);
	}
	
}
