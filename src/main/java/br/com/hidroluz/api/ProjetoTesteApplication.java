package br.com.hidroluz.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjetoTesteApplication {
	
	@Value("${paginacao.qtd_por_pagina}")
	private int qtd;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoTesteApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("### QTD = " + this.qtd);
			System.out.println("Hello Wordl");
		};
	}
}
