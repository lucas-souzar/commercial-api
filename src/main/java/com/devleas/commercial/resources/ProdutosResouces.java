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

import com.devleas.commercial.domain.Produto;
import com.devleas.commercial.services.ProdutosService;

@CrossOrigin("*")
@RestController
@RequestMapping("/{user}/produtos")
public class ProdutosResouces {
	
	@Autowired
	private ProdutosService produtosService;
	
	@PostMapping
	public ResponseEntity<Produto> salvar(@Valid @RequestBody Produto produto) {
		produto = produtosService.salvar(produto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(produto.getId()).toUri();
		
		return ResponseEntity.created(uri).body(produto);
	}
	
	@GetMapping
	public ResponseEntity<List<Produto>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(produtosService.listar());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Produto>> buscar(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(produtosService.buscar(id));
	}
	
}
