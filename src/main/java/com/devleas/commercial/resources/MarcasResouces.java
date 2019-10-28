package com.devleas.commercial.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.devleas.commercial.domain.Marca;
import com.devleas.commercial.services.MarcasService;

@CrossOrigin("*")
@RestController
@RequestMapping("/marcas")
public class MarcasResouces {

	@Autowired
	private MarcasService marcasService;
	
	@PostMapping
	public ResponseEntity<Marca> salvar(@Valid @RequestBody Marca marca) {
		marca = marcasService.salvar(marca);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(marca.getId()).toUri();
		
		//return ResponseEntity.created(uri).build();
		return ResponseEntity.created(uri).body(marca);
	}
	
	@GetMapping
	public ResponseEntity<List<Marca>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(marcasService.listar());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Marca>> buscar(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(marcasService.buscar(id));
	}
	
	
	
}
