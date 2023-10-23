package com.aps.pizzaria.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aps.pizzaria.model.Bebida;
import com.aps.pizzaria.model.Cliente;
import com.aps.pizzaria.model.Pizza;
import com.aps.pizzaria.model.Produto;
import com.aps.pizzaria.service.ProdutoService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CardapioController {	
	
	@Autowired
	ProdutoService produtoService;
	
		
	@GetMapping("/cardapio")
	public ModelAndView pedido(HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("telas/cardapio");
		
		try {
			
			Cliente usuarioLogado = (Cliente) session.getAttribute("usuarioLogado");
			if(usuarioLogado == null) {
				
				mv.setViewName("redirect:/login");
				
			} else {
				
				List<Produto> listaProdutos = produtoService.listar();
				
				if (listaProdutos.size() == 0) {
					
					produtoService.registrar(new Produto("Mussarela Brotinho", "Mussarela, Tomate e Oregano", 19.99f));
					
					produtoService.registrar(new Produto("Mussarela", "Mussarela, Tomate e Oregano", 39.99f));
					
					produtoService.registrar(new Produto("Calabresa Brotinho", "Mussarela, Calabresa e Cebola", 19.99f));
					
					produtoService.registrar(new Produto("Calabresa", "Mussarela, Calabresa e Cebola", 39.99f));
					
					produtoService.registrar(new Produto("Portuguesa Brotinho", "Mussarela, Presunto, Palmito, Ovo, Cebola ", 24.99f));
					
					produtoService.registrar(new Produto("Portuguesa", "Mussarela, Presunto, Palmito, Ovo, Cebola ", 44.99f));
					
					produtoService.registrar(new Produto("Bacon Brotinho", "Mussarela, Tomate em Rodelas e Bacon", 29.99f));					
					
					produtoService.registrar(new Produto("Bacon", "Mussarela, Tomate em Rodelas e Bacon", 49.99f));
					
					produtoService.registrar(new Produto("Coca Cola", "600ml", 6.50f));
					
					produtoService.registrar(new Produto("Coca Cola", "2 Litros", 14.00f));
					
					produtoService.registrar(new Produto("Fanta Laranja", "2 Litros", 12.49f));
					
					produtoService.registrar(new Produto("Suco de Laranja", "1 Litro", 5f));
				}
				
				
				mv.addObject("listaProduto", produtoService.listar());
				
			}
			
		} catch (Exception e) {
			
			mv.setViewName("redirect:/login");
			
		}
		
		return mv;
		
	}
	
}
