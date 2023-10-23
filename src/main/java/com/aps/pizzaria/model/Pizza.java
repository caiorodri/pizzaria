package com.aps.pizzaria.model;


public class Pizza extends Produto{

	public Pizza(Long id,String nome, String descricao, float valor) {
		super(id, nome, descricao, valor);
	}

	public Pizza(String nome, String descricao, float valor) {
		super(nome, descricao, valor);

	}

}
