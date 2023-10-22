package com.aps.pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aps.pizzaria.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{	
	
	@Query(value = "SELECT c FROM Cliente c WHERE c.email = ?1 AND c.senha = ?2")
	public Cliente recuperar(String email, String senha);
	
}
