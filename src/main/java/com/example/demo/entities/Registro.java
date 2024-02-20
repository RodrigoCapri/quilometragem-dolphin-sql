package com.example.demo.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_registro")
public class Registro implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String odometro;
	private String destino;
	private Instant moment;
	private String observation;
	
	@ManyToOne
	@JoinColumn(name = "id_carro")
	private Carro carro;
	
	@ManyToOne
	@JoinColumn(name = "id_motorista")
	private Motorista motorista;
	
	public Registro() {
	}

	public Registro(Long id, String odometro, String destino, Instant moment, String observation, Carro carro, Motorista motorista) {
		this.id = id;
		this.odometro = odometro;
		this.destino = destino;
		this.moment = moment;
		this.observation = observation;
		this.carro = carro;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
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
		Registro other = (Registro) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Registro [id=" + id + ", odometro=" + odometro + ", destino=" + destino + ", moment=" + moment
				+ ", observation=" + observation + ", carro=" + carro + ", motorista=" + motorista + "]";
	}
	
}
