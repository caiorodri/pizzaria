package com.aps.pizzaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String nome;
	private String descricao;
	private float valor;
	
	public boolean atualizarValor(float valor) {
		
		return false;
			
	}
	
	public Produto(String nome, String descricao, float valor){
		
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		
	}
	
}
