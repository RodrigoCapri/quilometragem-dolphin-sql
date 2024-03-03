package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MotoristaDTO;
import com.example.demo.entities.Carro;
import com.example.demo.entities.Motorista;
import com.example.demo.entities.Registro;
import com.example.demo.repositories.CarroRepository;
import com.example.demo.repositories.MotoristaRepository;
import com.example.demo.repositories.RegistroRepository;
import com.example.demo.services.exceptions.DatabaseException;
import com.example.demo.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MotoristaService {

	@Autowired
	private MotoristaRepository repository;
	
	@Autowired
	private CarroRepository car_repo;
	
	@Autowired
	private RegistroRepository reg_repo;
	
	public List<Motorista> findAll(){
		return repository.findAll();
	}
	
	public Motorista findById(Long id) {
		Optional<Motorista> obj = repository.findById(id);
		
		return obj.orElseThrow( () -> new ResourceNotFoundException(id) );
	}
	
	public Motorista insert(Motorista obj) {
		
		if( obj.getCarro() == null )
			throw new DatabaseException("Não é possível salvar um motorista sem especificar um carro!");
		
		Optional<Carro> opt = car_repo.findById(obj.getCarro().getId());
		Carro car = opt.orElseThrow( () -> new ResourceNotFoundException("Carro não encontrado "+obj.getCarro().getId()) );
		
		car.setMotorista(obj);
		car_repo.save(car);
		
		return obj;
	}
	
	public Motorista update(Long id, Motorista obj) {
		try {
			
			Optional<Motorista> opt_mot = repository.findById(id);
			Motorista mot = opt_mot.orElseThrow( () -> new ResourceNotFoundException(id) );
			
			mot.setNome( obj.getNome() != null ? obj.getNome() : mot.getNome() );
			mot.setEmail( obj.getEmail() != null ? obj.getEmail() : mot.getEmail() );
			mot.setTelefone( obj.getTelefone() != null ? obj.getTelefone() : mot.getTelefone());
			mot.setCpf( obj.getCpf() != null ? obj.getCpf() : mot.getCpf() );
			mot.setCarteira( obj.getCarteira() != null ? obj.getCarteira() : mot.getCarteira() );
			mot.setSenha( obj.getSenha() != null ? obj.getSenha() : mot.getSenha() );
			mot.setNum_acesso( obj.getNum_acesso() != null ? obj.getNum_acesso() : mot.getNum_acesso() );
			
			Optional<Carro> opt = car_repo.findById(mot.getCarro().getId());
			Carro car = opt.orElseThrow( () -> new ResourceNotFoundException("Carro não encontrado "+obj.getCarro().getId()) );
			
			car.setMotorista(mot);
			car_repo.save(car);
			
			return mot;
			
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public List<Registro> getRegistros(Long id){
		
		Motorista mot = repository.findById(id).orElseThrow( () -> new ResourceNotFoundException(id) );
		
		List<Registro> sets = reg_repo.findByMotorista(mot);
		
		return sets;
	}
	
	public Motorista fromDTO(MotoristaDTO objDTO) {
		
		Carro car = null;
		
		if(objDTO.getCarro() != null) {
			Optional<Carro> opt = car_repo.findById(objDTO.getCarro());
			car = opt.get();
		}
		
		Motorista mot = new Motorista(objDTO.getId(), objDTO.getNome(), objDTO.getEmail(), objDTO.getTelefone(), objDTO.getCpf(), objDTO.getCarteira(), null, null, car);
		
		return mot;
	}
	
}
