package br.com.hidroluz.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.hidroluz.api.entity.Cliente;

@Transactional(readOnly = true)
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	Cliente findByLoginAndSenha(String login, String senha);
	
	Cliente findByLogin(String login);
	

}
