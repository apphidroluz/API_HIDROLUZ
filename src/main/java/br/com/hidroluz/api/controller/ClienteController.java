package br.com.hidroluz.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hidroluz.api.dtos.ClienteDTO;
import br.com.hidroluz.api.entity.Cliente;
import br.com.hidroluz.api.repositories.ClienteRepository;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	@PostMapping
	public ResponseEntity<Cliente> cadastrar(@RequestBody ClienteDTO clienteDto){
		
		
		
		Cliente cliente = new Cliente(null, clienteDto.getLogin(), clienteDto.getSenha());
//		
        this.clienteRepository.save(cliente);
//		
//		List<Cliente> cli = clienteRepository.findAll();
//		cli.forEach(System.out::println);
		return ResponseEntity.ok(cliente);
		
	}

}