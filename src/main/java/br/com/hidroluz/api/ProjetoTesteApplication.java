package br.com.hidroluz.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ProjetoTesteApplication {
	
//	@Autowired
//	private ClienteRepository clienteRepository;
	


	public static void main(String[] args) {
		
		
		SpringApplication.run(ProjetoTesteApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {

//			Cliente cliente = new Cliente(null, "TESTE", "TESTE");
//			
//			this.clienteRepository.save(cliente);
//			
//			List<Cliente> cli = clienteRepository.findAll();
//			cli.forEach(System.out::println);
//			
//			System.out.println("### QTD = ");
//			System.out.println("Hidroluz");

			/*Cliente cliente = new Cliente(null, "TESTE", "TESTE");
>>>>>>> 929ddb2ce8f4a47d13278b560ca8c70b45593c18
			
		
			
<<<<<<< HEAD
=======
			System.out.println("### QTD = ");
			System.out.println("Hidroluz");*/

		};
	}
}
