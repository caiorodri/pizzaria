package com.aps.pizzaria.model;

public class Bebida extends Produto{

	public Bebida(Long id, String nome, String descricao, float valor) {
		super(id, nome, descricao, valor);
	}
	
	public Bebida(String nome, String descricao, float valor) {
		super(nome, descricao, valor);

	}
}
