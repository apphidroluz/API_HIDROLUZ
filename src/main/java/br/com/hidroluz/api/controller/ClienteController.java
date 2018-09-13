package br.com.hidroluz.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hidroluz.api.dtos.ClienteDTO;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	
	@PostMapping
	public ResponseEntity<ClienteDTO> cadastrar(@RequestBody ClienteDTO clienteDto){
		
		clienteDto.setId_Cliente(1);
		return ResponseEntity.ok(clienteDto);
		
	}

}
