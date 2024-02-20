package com.example.demo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RegistroDTO;
import com.example.demo.entities.Registro;
import com.example.demo.services.RegistroService;

@RestController
@RequestMapping(value = "/registros")
public class RegistroResource {
	
	@Autowired
	private RegistroService service;
	
	@GetMapping
	public ResponseEntity< List<RegistroDTO> > findAll(){
		
		List<Registro> list = service.findAll();
		
		List<RegistroDTO> listDTO = list.stream().map( obj -> new RegistroDTO(obj) ).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}
	
}
