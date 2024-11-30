package com.example.demo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.dto.MotoristaDTO;
import com.example.demo.dto.RegistroDTO;
import com.example.demo.entities.Motorista;
import com.example.demo.entities.Registro;
import com.example.demo.services.MotoristaService;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping(value = "/motoristas")
public class MotoristaResource {
	
	@Autowired
	private MotoristaService service;
	
	@GetMapping
	public ResponseEntity< List<MotoristaDTO> > findAll(){
		List<Motorista> list = service.findAll();
		
		List<MotoristaDTO> listDTO = list.stream().map( obj -> new MotoristaDTO(obj) ).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity< Motorista > findById(@PathVariable Long id){
		
		Motorista mot = service.findById(id);
		
		return ResponseEntity.ok().body( mot );
	}
	
	@PostMapping
	public ResponseEntity< MotoristaDTO > insert(@RequestBody MotoristaDTO objDTO){
		
		Motorista mot = service.fromDTO(objDTO);
		mot = service.insert(mot);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(mot.getId()).toUri();
		
		return ResponseEntity.created(uri).body( new MotoristaDTO(mot) );
	}
	
	@PutMapping("/{id}")
	public ResponseEntity< MotoristaDTO > update(@PathVariable Long id, @RequestBody MotoristaDTO objDTO){
		
		Motorista mot = service.fromDTO(objDTO);
		mot = service.update(id, mot);
		
		return ResponseEntity.ok().body( new MotoristaDTO(mot) );
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity< Void > delete(@PathVariable Long id){
		
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}/registros")
	public ResponseEntity< List<RegistroDTO> > getRegistros(@PathVariable Long id){
		
		List<Registro> list = service.getRegistros(id);
		
		List<RegistroDTO> listDTO = list.stream().map( obj -> new RegistroDTO(obj) ).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}
	
}
