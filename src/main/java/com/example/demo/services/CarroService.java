package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Carro;
import com.example.demo.repositories.CarroRepository;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository repository;
	
	public List<Carro> findAll(){
		return repository.findAll();
	}
	
}
