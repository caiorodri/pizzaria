package com.aps.pizzaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class ClienteController {

	@GetMapping("/sair")
	public String sair(HttpSession session) {
		
		session.setAttribute("usuarioLogado", null);
		return "redirect:/";
	}
	
}
