package com.example.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entities.Carro;
import com.example.demo.entities.Motorista;
import com.example.demo.enums.CarColor;
import com.example.demo.repositories.CarroRepository;
import com.example.demo.repositories.MotoristaRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private MotoristaRepository moto_repo;
	
	@Autowired
	private CarroRepository car_repo;
	
	@Override
	public void run(String... args) throws Exception {
		Motorista mot1 = new Motorista(null, "Alex Many", "alex@gmail.com", "42977778888", "00033344481", "45678912", "1100", 0, null);
		Motorista mot2 = new Motorista(null, "Debora Manta", "debora@gmail.com", "41933334444", "99988834512", "32165455", "7958", 0, null);
		Motorista mot3 = new Motorista(null, "Everton Sabre", "everton@gmail.com", "1155551111", "14725896302", "96385211", "1532", 0, null);
		
		moto_repo.saveAll(Arrays.asList(mot1, mot2, mot3));
		
		Carro car1 = new Carro(null, "Fiat UNO", 2010, "AB3312", CarColor.VERMELHO, null);
		Carro car2 = new Carro(null, "Fiat UNO", 2010, "BG4577", CarColor.BRANCO, null);
		
		car_repo.saveAll(Arrays.asList(car1, car2));
	}
	
}
