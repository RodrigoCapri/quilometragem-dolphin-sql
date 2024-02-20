package com.example.demo.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.example.demo.enums.CarColor;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_carro")
public class Carro implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String modelo;
	private Integer ano;
	private String placa;
	private Integer cor;
	
	@OneToOne(mappedBy = "carro", cascade = CascadeType.ALL)
	private Motorista motorista; //Um Carro tem um Motorista
	
	@OneToMany(mappedBy = "carro")
	private Set<Registro> registros = new HashSet<>();
	
	public Carro() {
	}

	public Carro(Long id, String modelo, Integer ano, String placa, CarColor cor) {
		this.id = id;
		this.modelo = modelo;
		this.ano = ano;
		this.placa = placa;
		this.cor = cor.getCode();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public CarColor getCor() {
		return CarColor.valueOf(this.cor);
	}

	public void setCor(CarColor cor) {
		if( cor != null )
			this.cor = cor.getCode();
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public Set<Registro> getRegistros() {
		return registros;
	}

	public void setRegistros(Set<Registro> registros) {
		this.registros = registros;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Carro [id=" + id + ", modelo=" + modelo + ", ano=" + ano + ", placa=" + placa + ", cor=" + cor
				+ ", motorista=" + motorista + ", registros=" + registros + "]";
	}
	
}
