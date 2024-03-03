package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Motorista;


public interface MotoristaRepository extends JpaRepository<Motorista, Long>{
	
}
