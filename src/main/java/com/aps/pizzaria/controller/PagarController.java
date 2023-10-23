package com.aps.pizzaria.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aps.pizzaria.model.Cliente;

import jakarta.servlet.http.HttpSession;

@Controller
public class PagarController {

	@GetMapping("/pagar")
	public ModelAndView pagar(HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("telas/pagar");
		
		try {
			

			Cliente usuarioLogado = (Cliente) session.getAttribute("usuarioLogado");
			
			if(usuarioLogado != null) {
				
				
				mv.addObject("total", session.getAttribute("valorTotal"));
				mv.addObject("endereco", usuarioLogado.getEndereco());
				
			}
			

		} catch (Exception e) {
			
			mv.setViewName("redirect:/");
			
		}		
		
		return mv;
	}
	
	@GetMapping("/notaFiscal")
	public ModelAndView notaFiscal(HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("telas/notaFiscal");
		
		try {
			

			Cliente usuarioLogado = (Cliente) session.getAttribute("usuarioLogado");
			
			if(usuarioLogado != null) {
				
				
				mv.addObject("total", session.getAttribute("valorTotal"));
				mv.addObject("endereco", usuarioLogado.getEndereco());
				mv.addObject("carrinho", session.getAttribute("pedido"));
			}
			

		} catch (Exception e) {
			
			mv.setViewName("redirect:/");
			
		}		
		
		return mv;
	}
}
