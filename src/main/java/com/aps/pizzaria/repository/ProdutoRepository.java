package com.aps.pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aps.pizzaria.model.Cliente;
import com.aps.pizzaria.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{	
	
}
