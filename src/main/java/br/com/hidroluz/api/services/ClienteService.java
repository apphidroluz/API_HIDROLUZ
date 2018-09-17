package br.com.hidroluz.api.services;

import java.util.Optional;

import br.com.hidroluz.api.entity.Cliente;

public interface ClienteService {
	
	Optional<Cliente> buscarPorLogin(String login);

}
