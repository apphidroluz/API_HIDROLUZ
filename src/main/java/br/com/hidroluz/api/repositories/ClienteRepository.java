package br.com.hidroluz.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hidroluz.api.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	Cliente findByLogin(String login);

}
