package br.com.hidroluz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hidroluz.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
	
	Cliente findByLogin(String Login);

}
