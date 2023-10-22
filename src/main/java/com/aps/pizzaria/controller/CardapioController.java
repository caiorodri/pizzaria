package com.aps.pizzaria.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aps.pizzaria.model.Bebida;
import com.aps.pizzaria.model.Cliente;
import com.aps.pizzaria.model.Pizza;

import jakarta.servlet.http.HttpSession;

@Controller
public class CardapioController {

	ArrayList<Pizza> listaPizzas = new ArrayList<>();
	ArrayList<Bebida> listaBebidas = new ArrayList<>();
	
	
	@GetMapping("/cardapio")
	public ModelAndView pedido(HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("telas/cardapio");
		
		try {
			
			Cliente usuarioLogado = (Cliente) session.getAttribute("usuarioLogado");
			
			if(usuarioLogado == null) {
				
				mv.setViewName("redirect:/login");
				
			} else {
				
				if (listaPizzas.size() == 0) {
					listaPizzas.add(new Pizza("Mussarela Brotinho", "Mussarela, Tomate e Oregano", 19.99f));
					listaPizzas.add(new Pizza("Mussarela", "Mussarela, Tomate e Oregano", 39.99f));
					listaPizzas.add(new Pizza("Calabresa Brotinho", "Mussarela, Calabresa e Cebola", 19.99f));
					listaPizzas.add(new Pizza("Calabresa", "Mussarela, Calabresa e Cebola", 39.99f));
					listaPizzas.add(new Pizza("Portuguesa Brotinho", "Mussarela, Presunto, Palmito, Ovo, Cebola ", 24.99f));
					listaPizzas.add(new Pizza("Portuguesa", "Mussarela, Presunto, Palmito, Ovo, Cebola ", 44.99f));
					listaPizzas.add(new Pizza("Bacon Brotinho", "Mussarela, Tomate em Rodelas e Bacon", 29.99f));
					listaPizzas.add(new Pizza("Bacon", "Mussarela, Tomate em Rodelas e Bacon", 49.99f));
					
				}
				
				if (listaBebidas.size() == 0) {
					listaBebidas.add(new Bebida("Coca Cola", "600ml", 6.50f));
					listaBebidas.add(new Bebida("Coca Cola", "2 Litros", 14.00f));
					listaBebidas.add(new Bebida("Fanta Laranja", "2 Litros", 12.49f));
					listaBebidas.add(new Bebida("Suco de Laranja", "1 Litro", 5f));
					
				}
					
				mv.addObject("listaPizzas", listaPizzas);
				mv.addObject("listaBebidas", listaBebidas);
				
			}
			
		} catch (Exception e) {
			
			mv.setViewName("redirect:/login");
			
		}
		
		return mv;
		
	}
	
}
