package com.example.demo.dto;

import java.io.Serializable;

import com.example.demo.entities.Carro;
import com.example.demo.enums.CarColor;

public class CarroDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String modelo;
	private Integer ano;
	private String placa;
	private Integer cor;
	
	private Long motorista;
	
	public CarroDTO() {	
	}
	
	public CarroDTO(Carro obj) {
		this.id = obj.getId();
		this.modelo = obj.getModelo();
		this.ano = obj.getAno();
		this.placa = obj.getPlaca();
		this.cor = obj.getCor().getCode();
		this.motorista = obj.getMotorista() != null ? obj.getMotorista().getId() : null;
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
		this.cor = cor.getCode();
	}

	public Long getMotorista() {
		return motorista;
	}

	public void setMotorista(Long motorista) {
		this.motorista = motorista;
	}
	
}
