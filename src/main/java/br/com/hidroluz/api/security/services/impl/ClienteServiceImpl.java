package br.com.hidroluz.api.security.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hidroluz.api.security.entity.Cliente;
import br.com.hidroluz.api.security.repositories.ClienteRepository;
import br.com.hidroluz.api.security.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Optional<Cliente> buscarPorLogin(String login){
		
		return Optional.ofNullable(this.clienteRepository.findByLogin(login));
		
	}

}
