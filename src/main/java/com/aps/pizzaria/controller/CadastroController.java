package com.aps.pizzaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.aps.pizzaria.model.Cliente;
import com.aps.pizzaria.service.ClienteService;

import jakarta.validation.Valid;

@Controller
public class CadastroController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/cadastro")
	public ModelAndView cadastro(Cliente cliente) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("telas/cadastro");
		mv.addObject("cliente", new Cliente());
		return mv;
	
	}
	
	
	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(@Valid Cliente cliente, BindingResult br) {
		
		ModelAndView mv = new ModelAndView();
		
		if(br.hasErrors()) {
			
			mv.setViewName("telas/cadastro");
			mv.addObject("cliente");
		
		} else {
			
			mv.setViewName("redirect:/login");
			try {
				clienteService.registrar(cliente);
				
			} catch (Exception e) {
				
				mv.setViewName("redirect:/cadastro");
			
			}
			
		}
		
			
		return mv;
		
	}
	
}
