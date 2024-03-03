package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Registro;
import com.example.demo.entities.Motorista;
import com.example.demo.entities.Carro;



public interface RegistroRepository extends JpaRepository<Registro, Long>{
	
	List<Registro> findByMotorista(Motorista motorista);
	
	List<Registro> findByCarro(Carro carro);
	
}
