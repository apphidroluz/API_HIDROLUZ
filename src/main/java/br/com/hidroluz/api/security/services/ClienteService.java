package br.com.hidroluz.api.security.services;

import java.util.Optional;

import br.com.hidroluz.api.security.entity.Cliente;

public interface ClienteService {
	
	Optional<Cliente> buscarPorLogin(String login);

}
