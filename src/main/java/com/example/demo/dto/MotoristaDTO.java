package com.example.demo.dto;

import java.io.Serializable;

import com.example.demo.entities.Motorista;

public class MotoristaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String cpf;
	private String carteira;
	
	private Long carro;

	public MotoristaDTO() {
		
	}
	
	public MotoristaDTO(Motorista mot) {
		this.id = mot.getId();
		this.nome = mot.getNome();
		this.email = mot.getEmail();
		this.telefone = mot.getTelefone();
		this.cpf = mot.getCpf();
		this.carteira = mot.getCarteira();
		this.carro = mot.getCarro() != null ? mot.getCarro().getId() : null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCarteira() {
		return carteira;
	}

	public void setCarteira(String carteira) {
		this.carteira = carteira;
	}

	public Long getCarro() {
		return carro;
	}

	public void setCarro(Long carro) {
		this.carro = carro;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}

