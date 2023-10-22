package com.aps.pizzaria.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aps.pizzaria.model.Cliente;
import com.aps.pizzaria.model.Produto;
import com.aps.pizzaria.service.ClienteService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/login")
	public ModelAndView login(HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("telas/login");
		mv.addObject("clienteLogin", new Cliente());
		
		return mv;
	
	}
	
	@PostMapping("/logar")
	public String logar(Cliente cliente, HttpSession session) {
		
		cliente = clienteService.recuperar(cliente.getEmail(), cliente.getSenha());
		
		if(cliente == null) {
			return "redirect:/login";
		} else {
			session.setAttribute("usuarioLogado", cliente);
			session.setAttribute("carrinho", new ArrayList<Produto>());
			return "redirect:/";
		}
	}
	
}
