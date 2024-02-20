package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Registro;
import com.example.demo.repositories.RegistroRepository;

@Service
public class RegistroService {

	@Autowired
	private RegistroRepository repository;
	
	public List<Registro> findAll(){
		return repository.findAll();
	}
	
}
