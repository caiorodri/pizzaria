package com.aps.pizzaria.model;


import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cliente")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@NotBlank(message="Nome não pode ser vazio")
	private String nome;
	
	@Column(unique = true)
	@CPF(message = "CPF inválido!")
	private String cpf;
	
	private String senha;
	
	private String endereco;
	
	private String telefone;
	
	@Column(unique = true)
	private String email;
	
	public Cliente(String nome, String endereco) {
		
		this.nome = nome;
		this.endereco = endereco;
		
	}
	
	public boolean logar(){
		
		return false;
		
	}
	
	public boolean resetSenha(){
		
		return false;
	}

}
