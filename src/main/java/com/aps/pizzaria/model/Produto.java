package com.aps.pizzaria.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
	
	private String nome;
	private String descricao;
	private float valor;
	
	public boolean atualizarValor(float valor) {
		
		return false;
			
	}
	
}
