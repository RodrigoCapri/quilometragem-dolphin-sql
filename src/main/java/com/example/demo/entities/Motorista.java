package com.example.demo.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_motorista")
public class Motorista implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String email;
	private String telefone;
	private String cpf;
	private String carteira;
	private String senha = "root";
	private Integer num_acesso = 0;
	
	@JsonIgnore
	@OneToOne
	@MapsId
	private Carro carro; //Motorista pertence a um Carro
	
	@JsonIgnore
	@OneToMany(mappedBy = "motorista")
	private Set<Registro> registros = new HashSet<>();
	
	public Motorista() {
	}

	public Motorista(Long id, String nome, String email, String telefone, String cpf, String carteira, String senha,
			Integer num_acesso, Carro carro) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cpf = cpf;
		this.carteira = carteira;
		this.senha = senha != null ? senha : this.senha;
		this.num_acesso = num_acesso != null ? num_acesso : this.num_acesso;
		this.carro = carro;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getNum_acesso() {
		return num_acesso;
	}

	public void setNum_acesso(Integer num_acesso) {
		this.num_acesso = num_acesso;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public Set<Registro> getRegistros() {
		return registros;
	}

	public void setRegistros(Set<Registro> registros) {
		this.registros = registros;
	}

	@Override
	public String toString() {
		return "Motorista [id=" + id + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", cpf=" + cpf
				+ ", carteira=" + carteira + ", senha=" + senha + ", num_acesso=" + num_acesso + ", carro=" + carro
				+ ", registros=" + registros + "]";
	}
	
}
