package com.devleas.commercial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devleas.commercial.domain.Produto;
import com.devleas.commercial.repository.ProdutosRepository;

@Service
public class ProdutosService {
	
	@Autowired
	private ProdutosRepository produtosRepository;
	
	public Produto salvar(Produto produto) {
		return produtosRepository.save(produto);
	}
	
	public List<Produto> listar(){
		return produtosRepository.findAll();
	}
	
	public Optional<Produto> buscar(Long id) {
		Optional<Produto> produto = produtosRepository.findById(id);
		return produto;
	}
	
}
