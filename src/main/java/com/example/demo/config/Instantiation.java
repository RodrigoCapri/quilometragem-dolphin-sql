package com.example.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entities.Motorista;
import com.example.demo.repositories.MotoristaRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private MotoristaRepository moto_repo;
	
	@Override
	public void run(String... args) throws Exception {
		Motorista mot1 = new Motorista(null, "Alex Many", "alex@gmail.com", "42977778888", "00033344481", "45678912", "1100", 0);
		Motorista mot2 = new Motorista(null, "Debora Manta", "debora@gmail.com", "41933334444", "99988834512", "32165455", "7958", 0);
		Motorista mot3 = new Motorista(null, "Everton Sabre", "everton@gmail.com", "1155551111", "14725896302", "96385211", "1532", 0);
		
		moto_repo.saveAll(Arrays.asList(mot1, mot2, mot3));
	}
	
}
