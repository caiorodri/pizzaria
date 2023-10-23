package com.aps.pizzaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aps.pizzaria.model.Cliente;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@GetMapping("/")
	public ModelAndView home(HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("telas/home");
		
		try {
			

			Cliente usuarioLogado = (Cliente) session.getAttribute("usuarioLogado");
			
			if(usuarioLogado != null) {
				
				
				mv.setViewName("redirect:/cardapio");
				
			}
			

		} catch (Exception e) {
			
			mv.setViewName("redirect:/");
			
		}		
		
		return mv;
	}
	
}
