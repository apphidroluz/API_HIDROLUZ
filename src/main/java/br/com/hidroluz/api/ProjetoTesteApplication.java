package br.com.hidroluz.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.hidroluz.api.entity.Cliente;
import br.com.hidroluz.api.repositories.ClienteRepository;

@SpringBootApplication
public class ProjetoTesteApplication {
	
	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
		
		
		SpringApplication.run(ProjetoTesteApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			Cliente cliente = new Cliente(null, "TESTE", "TESTE");
			
			this.clienteRepository.save(cliente);
			
			List<Cliente> cli = clienteRepository.findAll();
			cli.forEach(System.out::println);
			
			System.out.println("### QTD = ");
			System.out.println("Hidroluz");
		};
	}
}
