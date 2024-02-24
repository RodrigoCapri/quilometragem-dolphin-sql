package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CarroDTO;
import com.example.demo.entities.Carro;
import com.example.demo.entities.Motorista;
import com.example.demo.repositories.CarroRepository;
import com.example.demo.repositories.MotoristaRepository;
import com.example.demo.services.exceptions.DatabaseException;
import com.example.demo.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository repository;
	
	@Autowired
	private MotoristaRepository mot_repository;
	
	public List<Carro> findAll(){
		return repository.findAll();
	}
	
	public Carro findById(Long id) {
		
		Optional<Carro> optional = repository.findById(id);
		
		return optional.orElseThrow( () -> new ResourceNotFoundException(id) );
	}
	
	public Carro insert(Carro obj) {
		return repository.save(obj);
	}
	
	public Carro update(Long id, Carro obj) {
		try {
			Optional<Carro> opt = repository.findById(id);
			Carro entity = opt.orElseThrow( () -> new ResourceNotFoundException(id) );
			
			entity.setModelo( obj.getModelo() != null ? obj.getModelo() : entity.getModelo() );
			entity.setAno( obj.getAno() != null ? obj.getAno() : entity.getAno() );
			entity.setPlaca( obj.getPlaca() != null ? obj.getPlaca() : entity.getPlaca() );
			entity.setCor( obj.getCor() != null ? obj.getCor() : entity.getCor() );
			entity.setMotorista( obj.getMotorista() != null ? obj.getMotorista() : entity.getMotorista() );
			
			return repository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public void delete(Long id) {
		try {
			this.repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) { //Violação de integridade de dados
			throw new DatabaseException(e.getMessage()); 
		}
	}
	
	public Carro fromDTO(CarroDTO objDTO) {
		Carro car = new Carro(objDTO.getId(), objDTO.getModelo(), objDTO.getAno(), objDTO.getPlaca(), objDTO.getCor());
		
		if( objDTO.getMotorista() != null ) {
			Optional<Motorista> optional = mot_repository.findById(objDTO.getId());
			Motorista mot = optional.orElseThrow( () -> new ResourceNotFoundException(objDTO.getId()) );
			car.setMotorista( mot );
		}
		return car;
	}
	
}
