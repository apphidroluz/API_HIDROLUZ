package br.com.hidroluz.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.hidroluz.entity.Cliente;
import br.com.hidroluz.repositories.ClienteRepository;

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
			
			System.out.println("### QTD = ");
			System.out.println("Hidroluz");
		};
	}
}
