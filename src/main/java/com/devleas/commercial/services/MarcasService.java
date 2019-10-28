package com.devleas.commercial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devleas.commercial.domain.Marca;
import com.devleas.commercial.repository.MarcasRepository;

@Service
public class MarcasService {
	
	@Autowired
	private MarcasRepository marcasRepository;
	
	public Marca salvar(Marca marca) {
		return marcasRepository.save(marca);
	}
	
	public List<Marca> listar(){
		return marcasRepository.findAll();
	}
	
	public Optional<Marca> buscar(Long id) {
		Optional<Marca> marca = marcasRepository.findById(id);
		return marca;
	}
	
}
