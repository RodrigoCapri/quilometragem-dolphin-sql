package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Motorista;
import com.example.demo.repositories.MotoristaRepository;

@Service
public class MotoristaService {

	@Autowired
	private MotoristaRepository repository;
	
	public List<Motorista> findAll(){
		return repository.findAll();
	}
	
}
