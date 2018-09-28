package br.com.hidroluz.api;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.hidroluz.api.security.entity.Cliente;
import br.com.hidroluz.api.security.enums.PerfilEnum;
import br.com.hidroluz.api.security.repositories.ClienteRepository;
import br.com.hidroluz.api.security.repositories.XML_TABRepository;
import br.com.hidroluz.api.utils.SenhaUtil;


@SpringBootApplication
public class ProjetoTesteApplication {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private XML_TABRepository xmlRepository;

	public static void main(String[] args) {
		
		
		SpringApplication.run(ProjetoTesteApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {

			Optional<Cliente> cliente;
			/*cliente.setLogin("ROBSON");
			cliente.setSenha(SenhaUtils.gerarBCrypt("12345"));
			cliente.setPerfil(PerfilEnum.ROLE_ADMIN);
			*/
			//this.clienteRepository.save(cliente);
			
	
			//System.out.println(cliente);

			cliente = this.clienteRepository.findById(1);
			
	
			//System.out.println(dateTime);
			
		
			
			//List<XML_TAB> cli = xmlRepository.findByNumHidrometroAndData("173849273647582", dateTime);
			//cli.forEach(System.out::println);
			
//			List<XML_TAB> cli = xmlRepository.findByNumHidrometro("173849273647582");
//			cli.forEach(System.out::println);
//			
//			System.out.println("### QTD = ");
//			System.out.println("Hidroluz");


			
		


		};
	}
	
	public Date convertToDateViaSqlDate(LocalDate dateToConvert) {
	    return java.sql.Date.valueOf(dateToConvert);
	}
}