package com.aps.pizzaria.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.aps.pizzaria.model.Cliente;
import com.aps.pizzaria.model.Produto;
import com.aps.pizzaria.service.ProdutoService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PedidoController {

	@Autowired
	ProdutoService produtoService;
	
	@GetMapping("/pedido")
	public ModelAndView pedido(HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("telas/pedido");
		
		try {
			
			Cliente usuarioLogado = (Cliente) session.getAttribute("usuarioLogado");

			List<Produto> produtos = (List<Produto>) session.getAttribute("pedido");
			
			float total = 0;
			
			for(Produto produto: produtos) {
				
				total += produto.getValor();
				
			}
			mv.addObject("carrinho", produtos);
			mv.addObject("total", total);
			session.setAttribute("valorTotal", total);
			
			if(usuarioLogado == null) {
				
				mv.setViewName("redirect:/login");
				
			} else {
				
			}
		} catch (Exception e) {
			
			mv.setViewName("redirect:/login");
	
		}
				
		return mv;
			
	}
	
	@GetMapping("/adicionarPedido/{id}")
	public ModelAndView adicionarPedido(@PathVariable Long id, HttpSession session) {
		
		Produto produto = produtoService.recuperar(id);
		
		List<Produto> produtos = (List<Produto>) session.getAttribute("pedido");
		
		if (produtos == null) {
			produtos = new ArrayList<>();
		}
		
		produtos.add(produto);
		
		session.setAttribute("pedido", produtos);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/cardapio");
		
		return mv;
	}
	
	@GetMapping("/removerPedido/{id}")
	public ModelAndView removerPedido(@PathVariable Long id, HttpSession session) {
		
		Produto produto = produtoService.recuperar(id);
		
		List<Produto> produtos = (List<Produto>) session.getAttribute("pedido");
		
		if (produtos == null) {
			produtos = new ArrayList<>();
		}
		
		produtos.remove(produto);
		
		session.setAttribute("pedido", produtos);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/pedido");
		
		return mv;
	}
	
}
