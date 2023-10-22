package com.aps.pizzaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aps.pizzaria.model.Cliente;
import com.aps.pizzaria.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> listar(){
		
		return clienteRepository.findAll();
		
	}
	
	public Cliente recuperar(Long id) {
		
		return clienteRepository.findById(id).get();
		
	}
	
	public Cliente recuperar(String email, String senha) {
		
		return clienteRepository.recuperar(email, senha);
		
	}
	
	public Cliente registrar(Cliente cliente) {
		
		return clienteRepository.save(cliente);
		
	}
	
}
