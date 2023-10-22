package com.aps.pizzaria.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Pedido {

	private int numero;
	private Timestamp momento;
	private float valor;
	private String status;
	private String pagamento;
	
	public boolean adicionarItem() {
		
		return false;
	}
	
	public boolean finalizarPedido() {
		
		return false;
		
	}

}
