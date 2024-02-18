package com.example.demo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MotoristaDTO;
import com.example.demo.entities.Motorista;
import com.example.demo.services.MotoristaService;

@RestController
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
	
}
