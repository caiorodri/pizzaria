package com.aps.pizzaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aps.pizzaria.model.Cliente;
import com.aps.pizzaria.model.Produto;
import com.aps.pizzaria.repository.ClienteRepository;
import com.aps.pizzaria.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> listar(){
		
		return produtoRepository.findAll();
		
	}
	
	public Produto recuperar(Long id) {
		
		return produtoRepository.findById(id).get();
		
	}
	
	
	public Produto registrar(Produto produto) {
		
		return produtoRepository.save(produto);
		
	}
	
}
