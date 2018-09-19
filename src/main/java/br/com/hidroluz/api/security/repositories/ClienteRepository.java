package br.com.hidroluz.api.security.repositories;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hidroluz.api.security.entity.Cliente;

@Repository
@ComponentScan(basePackages = "br.com.hidroluz.api")
@ConfigurationProperties(prefix = "cliente")
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	Cliente findByLoginAndSenha(String login, String senha);
	
	Cliente findByLogin(String login);


	

}
