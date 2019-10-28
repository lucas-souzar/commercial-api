package com.devleas.commercial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devleas.commercial.domain.Produto;

public interface ProdutosRepository extends JpaRepository<Produto, Long>{
	
	
	
}
