package com.example.demo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CarroDTO;
import com.example.demo.entities.Carro;
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
	
}
