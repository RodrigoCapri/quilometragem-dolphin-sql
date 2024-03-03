package com.example.demo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.dto.CarroDTO;
import com.example.demo.dto.RegistroDTO;
import com.example.demo.entities.Carro;
import com.example.demo.entities.Registro;
import com.example.demo.enums.CarColor;
import com.example.demo.services.CarroService;

@RestController
@RequestMapping(value = "/carros")
public class CarroResource {

	@Autowired
	private CarroService service;
	
	@GetMapping
	public ResponseEntity< List<CarroDTO> > findAll(){
		
		List<Carro> list = service.findAll();
		
		List<CarroDTO> listDTO = list.stream().map( obj -> new CarroDTO(obj) ).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity< CarroDTO > findById(@PathVariable Long id){
		
		Carro obj = service.findById(id);
		
		return ResponseEntity.ok().body( new CarroDTO(obj) );
	}
	
	@GetMapping("/cores")
	public ResponseEntity< CarColor[] > getCores(){
		return ResponseEntity.ok().body(CarColor.values());
	}
	
	@PostMapping
	public ResponseEntity< CarroDTO > insert(@RequestBody CarroDTO objDTO){
		
		Carro obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
	
		return ResponseEntity.created(uri).body( new CarroDTO(obj) );	
	}
	
	@PutMapping("/{id}")
	public ResponseEntity< CarroDTO > update(@PathVariable Long id, @RequestBody CarroDTO objDTO){
		
		Carro obj = service.fromDTO(objDTO);
		
		obj = service.update(id, obj);
		
		return ResponseEntity.ok().body( new CarroDTO(obj) );
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity< Void > delete(@PathVariable Long id){
		
		this.service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}/registros")
	public ResponseEntity< List<RegistroDTO> > getRegistros(@PathVariable Long id){
		
		List<Registro> list = service.getRegistros(id);
		
		List<RegistroDTO> listDTO = list.stream().map( obj -> new RegistroDTO(obj) ).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}
	
}
