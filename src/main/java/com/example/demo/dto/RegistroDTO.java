package com.example.demo.dto;

import java.io.Serializable;
import java.time.Instant;

import com.example.demo.entities.Registro;

public class RegistroDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Long carro;
	private Long motorista;
	
	private String odometro;
	private String destino;
	private Instant moment;
	private String observation;
	
	public RegistroDTO() {
	}
	
	public RegistroDTO(Registro obj) {
		this.id = obj.getId();
		this.carro = obj.getCarro().getId();
		this.motorista = obj.getMotorista().getId();
		
		this.odometro = obj.getOdometro();
		this.destino = obj.getDestino();
		this.moment = obj.getMoment();
		this.observation = obj.getObservation();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCarro() {
		return carro;
	}

	public void setCarro(Long carro) {
		this.carro = carro;
	}

	public Long getMotorista() {
		return motorista;
	}

	public void setMotorista(Long motorista) {
		this.motorista = motorista;
	}

	public String getOdometro() {
		return odometro;
	}

	public void setOdometro(String odometro) {
		this.odometro = odometro;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}
	
}
